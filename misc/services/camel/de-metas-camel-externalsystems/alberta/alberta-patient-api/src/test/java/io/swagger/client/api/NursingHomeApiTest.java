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
import io.swagger.client.model.NursingHome;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * API tests for NursingHomeApi
 */
@Ignore
public class NursingHomeApiTest {

    private final NursingHomeApi api = new NursingHomeApi();

    /**
     * Daten eines einzelnen Pflegeheimes abrufen
     *
     * Szenario - das WaWi fragt bei Alberta nach, wie die Daten des Pflegeheimes mit der angegebenen Id sind
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void geNursingHomeTest() throws ApiException {
        String albertaApiKey = null;
        String _id = null;
        NursingHome response = api.geNursingHome(albertaApiKey, _id);

        // TODO: test validations
    }
    /**
     * Daten der neuen und geänderten Pflegeheime abrufen
     *
     * Szenario - das WaWi fragt bei Alberta nach, wie ob es neue oder geänderte Pflegeheime gibt
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getNewAndUpdatedNursingHomesTest() throws ApiException {
        String albertaApiKey = null;
        String updatedAfter = null;
        List<NursingHome> response = api.getNewAndUpdatedNursingHomes(albertaApiKey, updatedAfter);

        // TODO: test validations
    }
}