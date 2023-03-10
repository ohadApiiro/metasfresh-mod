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
import io.swagger.client.model.CustomerMapping;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerMappingApi {
    private ApiClient apiClient;

    public CustomerMappingApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CustomerMappingApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getCustomerMapping
     * @param albertaApiKey  (required)
     * @param customerId die Id des Kunden aus dem WaWi (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCustomerMappingCall(String albertaApiKey, String customerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/patient/customerMapping";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (customerId != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("customerId", customerId));

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
    private com.squareup.okhttp.Call getCustomerMappingValidateBeforeCall(String albertaApiKey, String customerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'albertaApiKey' is set
        if (albertaApiKey == null) {
            throw new ApiException("Missing the required parameter 'albertaApiKey' when calling getCustomerMapping(Async)");
        }
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new ApiException("Missing the required parameter 'customerId' when calling getCustomerMapping(Async)");
        }
        
        com.squareup.okhttp.Call call = getCustomerMappingCall(albertaApiKey, customerId, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Zuordnung Kunde (WaWi) zu Patient (Alberta) abrufen
     * Szenario - das WaWi fragt bei Alberta nach, welche Alberta-Id dem jeweiligen Kunden zugeordnet ist
     * @param albertaApiKey  (required)
     * @param customerId die Id des Kunden aus dem WaWi (required)
     * @return CustomerMapping
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CustomerMapping getCustomerMapping(String albertaApiKey, String customerId) throws ApiException {
        ApiResponse<CustomerMapping> resp = getCustomerMappingWithHttpInfo(albertaApiKey, customerId);
        return resp.getData();
    }

    /**
     * Zuordnung Kunde (WaWi) zu Patient (Alberta) abrufen
     * Szenario - das WaWi fragt bei Alberta nach, welche Alberta-Id dem jeweiligen Kunden zugeordnet ist
     * @param albertaApiKey  (required)
     * @param customerId die Id des Kunden aus dem WaWi (required)
     * @return ApiResponse&lt;CustomerMapping&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CustomerMapping> getCustomerMappingWithHttpInfo(String albertaApiKey, String customerId) throws ApiException {
        com.squareup.okhttp.Call call = getCustomerMappingValidateBeforeCall(albertaApiKey, customerId, null, null);
        Type localVarReturnType = new TypeToken<CustomerMapping>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Zuordnung Kunde (WaWi) zu Patient (Alberta) abrufen (asynchronously)
     * Szenario - das WaWi fragt bei Alberta nach, welche Alberta-Id dem jeweiligen Kunden zugeordnet ist
     * @param albertaApiKey  (required)
     * @param customerId die Id des Kunden aus dem WaWi (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCustomerMappingAsync(String albertaApiKey, String customerId, final ApiCallback<CustomerMapping> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getCustomerMappingValidateBeforeCall(albertaApiKey, customerId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CustomerMapping>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
