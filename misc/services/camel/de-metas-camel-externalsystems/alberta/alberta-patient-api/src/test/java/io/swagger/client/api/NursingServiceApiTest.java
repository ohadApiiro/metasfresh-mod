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

import io.swagger.client.ApiException;
import io.swagger.client.model.NursingService;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * API tests for NursingServiceApi
 */
@Ignore
public class NursingServiceApiTest {

    private final NursingServiceApi api = new NursingServiceApi();

    /**
     * Daten der neuen und geänderten Pflegedienste abrufen
     *
     * Szenario - das WaWi fragt bei Alberta nach, wie ob es neue oder geänderte Pflegedienste gibt
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getNewAndUpdatedNursingServicesTest() throws ApiException {
        String albertaApiKey = null;
        String updatedAfter = null;
        List<NursingService> response = api.getNewAndUpdatedNursingServices(albertaApiKey, updatedAfter);

        // TODO: test validations
    }
    /**
     * Daten eines einzelnen Pflegedienstes abrufen
     *
     * Szenario - das WaWi fragt bei Alberta nach, wie die Daten des Pflegedienstes mit der angegebenen Id sind
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getNursingServiceTest() throws ApiException {
        String albertaApiKey = null;
        String _id = null;
        NursingService response = api.getNursingService(albertaApiKey, _id);

        // TODO: test validations
    }
}