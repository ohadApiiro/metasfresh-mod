/*
 * Patient - Warenwirtschaft (Basis)
 * Synchronisation der Patienten mit der Warenwirtschaft
 *
 * OpenAPI spec version: 1.0.7
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
import io.swagger.client.model.Hospital;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalApi {
    private ApiClient apiClient;

    public HospitalApi() {
        this(Configuration.getDefaultApiClient());
    }

    public HospitalApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getHospital
     * @param albertaApiKey  (required)
     * @param _id eindeutige Id der Klinik (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getHospitalCall(String albertaApiKey, String _id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/hospital/{_id}"
            .replaceAll("\\{" + "_id" + "\\}", apiClient.escapeString(_id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (albertaApiKey != null)
        localVarHeaderParams.put("Alberta-Api-Key", apiClient.parameterToString(albertaApiKey));

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
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
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
    private com.squareup.okhttp.Call getHospitalValidateBeforeCall(String albertaApiKey, String _id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'albertaApiKey' is set
        if (albertaApiKey == null) {
            throw new ApiException("Missing the required parameter 'albertaApiKey' when calling getHospital(Async)");
        }
        // verify the required parameter '_id' is set
        if (_id == null) {
            throw new ApiException("Missing the required parameter '_id' when calling getHospital(Async)");
        }
        
        com.squareup.okhttp.Call call = getHospitalCall(albertaApiKey, _id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Daten einer einzelnen Klinik abrufen
     * Szenario - das WaWi fragt bei Alberta nach, wie die Daten der Klinik mit der angegebenen Id sind
     * @param albertaApiKey  (required)
     * @param _id eindeutige Id der Klinik (required)
     * @return Hospital
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Hospital getHospital(String albertaApiKey, String _id) throws ApiException {
        ApiResponse<Hospital> resp = getHospitalWithHttpInfo(albertaApiKey, _id);
        return resp.getData();
    }

    /**
     * Daten einer einzelnen Klinik abrufen
     * Szenario - das WaWi fragt bei Alberta nach, wie die Daten der Klinik mit der angegebenen Id sind
     * @param albertaApiKey  (required)
     * @param _id eindeutige Id der Klinik (required)
     * @return ApiResponse&lt;Hospital&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Hospital> getHospitalWithHttpInfo(String albertaApiKey, String _id) throws ApiException {
        com.squareup.okhttp.Call call = getHospitalValidateBeforeCall(albertaApiKey, _id, null, null);
        Type localVarReturnType = new TypeToken<Hospital>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Daten einer einzelnen Klinik abrufen (asynchronously)
     * Szenario - das WaWi fragt bei Alberta nach, wie die Daten der Klinik mit der angegebenen Id sind
     * @param albertaApiKey  (required)
     * @param _id eindeutige Id der Klinik (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getHospitalAsync(String albertaApiKey, String _id, final ApiCallback<Hospital> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getHospitalValidateBeforeCall(albertaApiKey, _id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Hospital>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getNewAndUpdatedHospitals
     * @param albertaApiKey  (required)
     * @param updatedAfter 2021-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getNewAndUpdatedHospitalsCall(String albertaApiKey, String updatedAfter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/hospital";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
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
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
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
    private com.squareup.okhttp.Call getNewAndUpdatedHospitalsValidateBeforeCall(String albertaApiKey, String updatedAfter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'albertaApiKey' is set
        if (albertaApiKey == null) {
            throw new ApiException("Missing the required parameter 'albertaApiKey' when calling getNewAndUpdatedHospitals(Async)");
        }
        // verify the required parameter 'updatedAfter' is set
        if (updatedAfter == null) {
            throw new ApiException("Missing the required parameter 'updatedAfter' when calling getNewAndUpdatedHospitals(Async)");
        }
        
        com.squareup.okhttp.Call call = getNewAndUpdatedHospitalsCall(albertaApiKey, updatedAfter, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Daten der neuen und geänderten Kliniken abrufen
     * Szenario - das WaWi fragt bei Alberta nach, wie ob es neue oder geänderte Kliniken gibt
     * @param albertaApiKey  (required)
     * @param updatedAfter 2021-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @return List&lt;Hospital&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Hospital> getNewAndUpdatedHospitals(String albertaApiKey, String updatedAfter) throws ApiException {
        ApiResponse<List<Hospital>> resp = getNewAndUpdatedHospitalsWithHttpInfo(albertaApiKey, updatedAfter);
        return resp.getData();
    }

    /**
     * Daten der neuen und geänderten Kliniken abrufen
     * Szenario - das WaWi fragt bei Alberta nach, wie ob es neue oder geänderte Kliniken gibt
     * @param albertaApiKey  (required)
     * @param updatedAfter 2021-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @return ApiResponse&lt;List&lt;Hospital&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Hospital>> getNewAndUpdatedHospitalsWithHttpInfo(String albertaApiKey, String updatedAfter) throws ApiException {
        com.squareup.okhttp.Call call = getNewAndUpdatedHospitalsValidateBeforeCall(albertaApiKey, updatedAfter, null, null);
        Type localVarReturnType = new TypeToken<List<Hospital>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Daten der neuen und geänderten Kliniken abrufen (asynchronously)
     * Szenario - das WaWi fragt bei Alberta nach, wie ob es neue oder geänderte Kliniken gibt
     * @param albertaApiKey  (required)
     * @param updatedAfter 2021-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getNewAndUpdatedHospitalsAsync(String albertaApiKey, String updatedAfter, final ApiCallback<List<Hospital>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getNewAndUpdatedHospitalsValidateBeforeCall(albertaApiKey, updatedAfter, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Hospital>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}