CREATE EXTENSION IF NOT EXISTS tablefunc;

CREATE OR REPLACE FUNCTION dlm.dlm_get_table_stats_partitioned(
    IN p_table_name text)
  RETURNS TABLE(PartitionedCount integer, UnPartitionedCount integer) AS
$BODY$
DECLARE 
	v_sql text;
BEGIN
	-- SELECT 1 FROM AD_Column c where c.AD_Table_ID=get_table_id(p_Table_Name) AND c.columnName='DLM_PArtition_ID';
	IF EXISTS (select 1 from information_schema.columns c where table_schema='public' AND table_name=lower(p_table_name) AND column_name=lower('DLM_Partition_ID'))
	THEN
	v_sql:='SELECT COALESCE(PartitionedCount,0) AS PartitionedCount, COALESCE(UnPartitionedCount,0) AS UnPartitionedCount
	FROM crosstab(
	''SELECT 
		DISTINCT ON (rowid, category) *  -- we need the "distinct" and the unions below to make sure that we always ent up with one "UnPartitionedCount" and one "PartitionedCount", also if one of those groups has no record at all
	  FROM (
	  SELECT 
		1 as rowid,
		CASE WHEN DLM_Partition_ID IS NULL THEN ''''UnPartitionedCount'''' ELSE ''''PartitionedCount'''' END as category, 
		COUNT(1)::integer as values'
		||' FROM '||p_Table_Name
		||' GROUP BY (DLM_PArtition_ID IS NULL)
	  union
	  SELECT 1, ''''UnPartitionedCount'''', 0
	  union
	  SELECT 1, ''''PartitionedCount'''', 0
	  ORDER BY Values DESC NULLS LAST
      ) d''
	)
	as (
	  RowId int,
	  PartitionedCount int,
	  UnPartitionedCount int
	);';
	ELSE
	v_sql:='SELECT '
		||' 0::integer AS PartitionedCount, COUNT(1)::integer AS UnpartitionedCount'
		||' FROM '||p_Table_Name||';';
	END IF;
	
--	RAISE NOTICE 'v_sql=%', v_sql;
	RETURN QUERY EXECUTE v_sql;
END;	
$BODY$
  LANGUAGE plpgsql STABLE
  COST 100
  ROWS 1000;
COMMENT ON FUNCTION dlm.dlm_get_table_stats_partitioned(text) IS
'For the given table name (no matter if that table is currently DLM''ed or not) this function returns the a row with two columns: PartitionedCount, UnPartitionedCount.
The function also works with tables that have no physical DLM_Partition_ID column and the table name can be case insensitive.
Note that the function needs to performa complete scan over the table in question to count the records.
The function requires the tablefunc module to be enabled ("CREATE EXTENSION tablefunc;").

Usage example: select how many records are already partitioned:
SELECT 
	t.TableName, 
	t.IsDLM, 
	stats.PartitionedCount, 
	stats.UnPartitionedCount, 
	CASE WHEN (stats.PartitionedCount + stats.UnPartitionedCount) > 0 
	THEN (stats.PartitionedCount::numeric / (stats.PartitionedCount + stats.UnPartitionedCount)::numeric * 100)
	ELSE 0::numeric
	END AS PartitionedPercent
FROM AD_Table t
	JOIN LATERAL dlm.dlm_get_table_stats_partitioned(t.TableName) AS stats ON true
WHERE t.IsDLM=''Y''
';

