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
import io.swagger.client.model.ArrayOfMappings;
import io.swagger.client.model.ArrayOfPatients;
import io.swagger.client.model.CustomerMapping;
import io.swagger.client.model.Patient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientApi {
    private ApiClient apiClient;

    public PatientApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PatientApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addPatient
     * @param body Der Patient (required)
     * @param albertaApiKey  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addPatientCall(Patient body, String albertaApiKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/patient";

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
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
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
    private com.squareup.okhttp.Call addPatientValidateBeforeCall(Patient body, String albertaApiKey, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling addPatient(Async)");
        }
        // verify the required parameter 'albertaApiKey' is set
        if (albertaApiKey == null) {
            throw new ApiException("Missing the required parameter 'albertaApiKey' when calling addPatient(Async)");
        }
        
        com.squareup.okhttp.Call call = addPatientCall(body, albertaApiKey, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Patient hinzufügen
     * Szenario - ein Patient wurde im WaWi angelegt und soll in Alberta übertragen werden
     * @param body Der Patient (required)
     * @param albertaApiKey  (required)
     * @return ArrayOfMappings
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ArrayOfMappings addPatient(Patient body, String albertaApiKey) throws ApiException {
        ApiResponse<ArrayOfMappings> resp = addPatientWithHttpInfo(body, albertaApiKey);
        return resp.getData();
    }

    /**
     * Patient hinzufügen
     * Szenario - ein Patient wurde im WaWi angelegt und soll in Alberta übertragen werden
     * @param body Der Patient (required)
     * @param albertaApiKey  (required)
     * @return ApiResponse&lt;ArrayOfMappings&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ArrayOfMappings> addPatientWithHttpInfo(Patient body, String albertaApiKey) throws ApiException {
        com.squareup.okhttp.Call call = addPatientValidateBeforeCall(body, albertaApiKey, null, null);
        Type localVarReturnType = new TypeToken<ArrayOfMappings>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Patient hinzufügen (asynchronously)
     * Szenario - ein Patient wurde im WaWi angelegt und soll in Alberta übertragen werden
     * @param body Der Patient (required)
     * @param albertaApiKey  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addPatientAsync(Patient body, String albertaApiKey, final ApiCallback<ArrayOfMappings> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addPatientValidateBeforeCall(body, albertaApiKey, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ArrayOfMappings>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getCreatedPatients
     * @param albertaApiKey  (required)
     * @param status created, updated oder archived - (required)
     * @param updatedAfter 2018-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getCreatedPatientsCall(String albertaApiKey, String status, String updatedAfter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/patient";

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
    private com.squareup.okhttp.Call getCreatedPatientsValidateBeforeCall(String albertaApiKey, String status, String updatedAfter, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'albertaApiKey' is set
        if (albertaApiKey == null) {
            throw new ApiException("Missing the required parameter 'albertaApiKey' when calling getCreatedPatients(Async)");
        }
        // verify the required parameter 'status' is set
        if (status == null) {
            throw new ApiException("Missing the required parameter 'status' when calling getCreatedPatients(Async)");
        }
        // verify the required parameter 'updatedAfter' is set
        if (updatedAfter == null) {
            throw new ApiException("Missing the required parameter 'updatedAfter' when calling getCreatedPatients(Async)");
        }
        
        com.squareup.okhttp.Call call = getCreatedPatientsCall(albertaApiKey, status, updatedAfter, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Patienten je nach Status abrufen
     * Szenario - das WaWi fragt in einem bestimmten Intervall bei Alberta nach, ob es neu angelegte, geänderte oder archivierte Patienten gibt ----- Aufruf &#x3D;&gt; patient/?status&#x3D;[status]&amp;updatedAfter&#x3D;[updatedAfter]
     * @param albertaApiKey  (required)
     * @param status created, updated oder archived - (required)
     * @param updatedAfter 2018-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @return ArrayOfPatients
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ArrayOfPatients getCreatedPatients(String albertaApiKey, String status, String updatedAfter) throws ApiException {
        ApiResponse<ArrayOfPatients> resp = getCreatedPatientsWithHttpInfo(albertaApiKey, status, updatedAfter);
        return resp.getData();
    }

    /**
     * Patienten je nach Status abrufen
     * Szenario - das WaWi fragt in einem bestimmten Intervall bei Alberta nach, ob es neu angelegte, geänderte oder archivierte Patienten gibt ----- Aufruf &#x3D;&gt; patient/?status&#x3D;[status]&amp;updatedAfter&#x3D;[updatedAfter]
     * @param albertaApiKey  (required)
     * @param status created, updated oder archived - (required)
     * @param updatedAfter 2018-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @return ApiResponse&lt;ArrayOfPatients&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ArrayOfPatients> getCreatedPatientsWithHttpInfo(String albertaApiKey, String status, String updatedAfter) throws ApiException {
        com.squareup.okhttp.Call call = getCreatedPatientsValidateBeforeCall(albertaApiKey, status, updatedAfter, null, null);
        Type localVarReturnType = new TypeToken<ArrayOfPatients>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Patienten je nach Status abrufen (asynchronously)
     * Szenario - das WaWi fragt in einem bestimmten Intervall bei Alberta nach, ob es neu angelegte, geänderte oder archivierte Patienten gibt ----- Aufruf &#x3D;&gt; patient/?status&#x3D;[status]&amp;updatedAfter&#x3D;[updatedAfter]
     * @param albertaApiKey  (required)
     * @param status created, updated oder archived - (required)
     * @param updatedAfter 2018-02-21T09:30:00.000Z (im UTC-Format) (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCreatedPatientsAsync(String albertaApiKey, String status, String updatedAfter, final ApiCallback<ArrayOfPatients> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getCreatedPatientsValidateBeforeCall(albertaApiKey, status, updatedAfter, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ArrayOfPatients>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updatePatient
     * @param body Der Patient (required)
     * @param albertaApiKey  (required)
     * @param id die Id des zu ändernden Patienten (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updatePatientCall(Patient body, String albertaApiKey, String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/patient";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (id != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("id", id));

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
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updatePatientValidateBeforeCall(Patient body, String albertaApiKey, String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling updatePatient(Async)");
        }
        // verify the required parameter 'albertaApiKey' is set
        if (albertaApiKey == null) {
            throw new ApiException("Missing the required parameter 'albertaApiKey' when calling updatePatient(Async)");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling updatePatient(Async)");
        }
        
        com.squareup.okhttp.Call call = updatePatientCall(body, albertaApiKey, id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Patient ändern
     * Szenario - ein Patient wurde im WaWi geändert und diese Änderungen sollen in Alberta übertragen werden ----- Aufruf &#x3D;&gt; patient/[patientenId]
     * @param body Der Patient (required)
     * @param albertaApiKey  (required)
     * @param id die Id des zu ändernden Patienten (required)
     * @return CustomerMapping
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CustomerMapping updatePatient(Patient body, String albertaApiKey, String id) throws ApiException {
        ApiResponse<CustomerMapping> resp = updatePatientWithHttpInfo(body, albertaApiKey, id);
        return resp.getData();
    }

    /**
     * Patient ändern
     * Szenario - ein Patient wurde im WaWi geändert und diese Änderungen sollen in Alberta übertragen werden ----- Aufruf &#x3D;&gt; patient/[patientenId]
     * @param body Der Patient (required)
     * @param albertaApiKey  (required)
     * @param id die Id des zu ändernden Patienten (required)
     * @return ApiResponse&lt;CustomerMapping&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CustomerMapping> updatePatientWithHttpInfo(Patient body, String albertaApiKey, String id) throws ApiException {
        com.squareup.okhttp.Call call = updatePatientValidateBeforeCall(body, albertaApiKey, id, null, null);
        Type localVarReturnType = new TypeToken<CustomerMapping>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Patient ändern (asynchronously)
     * Szenario - ein Patient wurde im WaWi geändert und diese Änderungen sollen in Alberta übertragen werden ----- Aufruf &#x3D;&gt; patient/[patientenId]
     * @param body Der Patient (required)
     * @param albertaApiKey  (required)
     * @param id die Id des zu ändernden Patienten (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updatePatientAsync(Patient body, String albertaApiKey, String id, final ApiCallback<CustomerMapping> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updatePatientValidateBeforeCall(body, albertaApiKey, id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CustomerMapping>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}