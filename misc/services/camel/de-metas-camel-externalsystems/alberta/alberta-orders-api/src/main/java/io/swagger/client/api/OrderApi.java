/*
 * Aufträge - Warenwirtschaft (Basis)
 * Synchronisation der Bestellungen aus Alberta mit den Aufträgen mit der Warenwirtschaft
 *
 * OpenAPI spec version: 1.0.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import com.google.gson.reflect.TypeToken;
import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;
import io.swagger.client.model.ArrayOfOrders;
import io.swagger.client.model.Order;
import io.swagger.client.model.OrderMapping;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderApi {
    private ApiClient apiClient;

    public OrderApi() {
        this(Configuration.getDefaultApiClient());
    }

    public OrderApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addOrder
     * @param body Die Bestellung (required)
     * @param albertaApiKey  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addOrderCall(Order body, String albertaApiKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/order";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (albertaApiKey != null)
        localVarHeaderParams.put("alberta-api-key", apiClient.parameterToString(albertaApiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json", "application/xml"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call addOrderValidateBeforeCall(Order body, String albertaApiKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling addOrder(Async)");
        }
        // verify the required parameter 'albertaApiKey' is set
        if (albertaApiKey == null) {
            throw new ApiException("Missing the required parameter 'albertaApiKey' when calling addOrder(Async)");
        }
        
        com.squareup.okhttp.Call call = addOrderCall(body, albertaApiKey, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Auftrag hinzufügen
     * Szenario - ein Auftrag wurde im WaWi angelegt und soll in Alberta übertragen werden
     * @param body Die Bestellung (required)
     * @param albertaApiKey  (required)
     * @return OrderMapping
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public OrderMapping addOrder(Order body, String albertaApiKey) throws ApiException {
        ApiResponse<OrderMapping> resp = addOrderWithHttpInfo(body, albertaApiKey);
        return resp.getData();
    }

    /**
     * Auftrag hinzufügen
     * Szenario - ein Auftrag wurde im WaWi angelegt und soll in Alberta übertragen werden
     * @param body Die Bestellung (required)
     * @param albertaApiKey  (required)
     * @return ApiResponse&lt;OrderMapping&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<OrderMapping> addOrderWithHttpInfo(Order body, String albertaApiKey) throws ApiException {
        com.squareup.okhttp.Call call = addOrderValidateBeforeCall(body, albertaApiKey, null, null);
        Type localVarReturnType = new TypeToken<OrderMapping>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Auftrag hinzufügen (asynchronously)
     * Szenario - ein Auftrag wurde im WaWi angelegt und soll in Alberta übertragen werden
     * @param body Die Bestellung (required)
     * @param albertaApiKey  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addOrderAsync(Order body, String albertaApiKey, final ApiCallback<OrderMapping> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addOrderValidateBeforeCall(body, albertaApiKey, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<OrderMapping>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCreatedOrders
     * @param albertaApiKey  (required)
     * @param status created (später ggf. archived) - (required)
     * @param updatedAfter 2018-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCreatedOrdersCall(String albertaApiKey, String status, String updatedAfter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/order";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (status != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("status", status));
        if (updatedAfter != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("updatedAfter", updatedAfter));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (albertaApiKey != null)
        localVarHeaderParams.put("alberta-api-key", apiClient.parameterToString(albertaApiKey));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getCreatedOrdersValidateBeforeCall(String albertaApiKey, String status, String updatedAfter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'albertaApiKey' is set
        if (albertaApiKey == null) {
            throw new ApiException("Missing the required parameter 'albertaApiKey' when calling getCreatedOrders(Async)");
        }
        // verify the required parameter 'status' is set
        if (status == null) {
            throw new ApiException("Missing the required parameter 'status' when calling getCreatedOrders(Async)");
        }
        // verify the required parameter 'updatedAfter' is set
        if (updatedAfter == null) {
            throw new ApiException("Missing the required parameter 'updatedAfter' when calling getCreatedOrders(Async)");
        }
        
        com.squareup.okhttp.Call call = getCreatedOrdersCall(albertaApiKey, status, updatedAfter, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Bestellungen je nach Status abrufen
     * Szenario - das WaWi fragt in einem bestimmten Intervall bei Alberta nach, ob es neu angelegte Bestellungen gibt ----- Aufruf &#x3D;&gt; order/?status&#x3D;[status]&amp;updatedAfter&#x3D;[updatedAfter]
     * @param albertaApiKey  (required)
     * @param status created (später ggf. archived) - (required)
     * @param updatedAfter 2018-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @return ArrayOfOrders
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ArrayOfOrders getCreatedOrders(String albertaApiKey, String status, String updatedAfter) throws ApiException {
        ApiResponse<ArrayOfOrders> resp = getCreatedOrdersWithHttpInfo(albertaApiKey, status, updatedAfter);
        return resp.getData();
    }

    /**
     * Bestellungen je nach Status abrufen
     * Szenario - das WaWi fragt in einem bestimmten Intervall bei Alberta nach, ob es neu angelegte Bestellungen gibt ----- Aufruf &#x3D;&gt; order/?status&#x3D;[status]&amp;updatedAfter&#x3D;[updatedAfter]
     * @param albertaApiKey  (required)
     * @param status created (später ggf. archived) - (required)
     * @param updatedAfter 2018-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @return ApiResponse&lt;ArrayOfOrders&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ArrayOfOrders> getCreatedOrdersWithHttpInfo(String albertaApiKey, String status, String updatedAfter) throws ApiException {
        com.squareup.okhttp.Call call = getCreatedOrdersValidateBeforeCall(albertaApiKey, status, updatedAfter, null, null);
        Type localVarReturnType = new TypeToken<ArrayOfOrders>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Bestellungen je nach Status abrufen (asynchronously)
     * Szenario - das WaWi fragt in einem bestimmten Intervall bei Alberta nach, ob es neu angelegte Bestellungen gibt ----- Aufruf &#x3D;&gt; order/?status&#x3D;[status]&amp;updatedAfter&#x3D;[updatedAfter]
     * @param albertaApiKey  (required)
     * @param status created (später ggf. archived) - (required)
     * @param updatedAfter 2018-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCreatedOrdersAsync(String albertaApiKey, String status, String updatedAfter, final ApiCallback<ArrayOfOrders> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCreatedOrdersValidateBeforeCall(albertaApiKey, status, updatedAfter, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ArrayOfOrders>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
