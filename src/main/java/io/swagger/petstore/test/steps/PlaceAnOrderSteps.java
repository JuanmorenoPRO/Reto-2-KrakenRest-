package io.swagger.petstore.test.steps;

import com.sqasa.rest.demo.utils.KrakenRest;
import net.serenitybdd.rest.SerenityRest;

public class PlaceAnOrderSteps {

    public void validateStatusCode(int statusCode){
        KrakenRest.compararStatus(statusCode);
    }

    public void validateStructureService(String pathStructure){
        KrakenRest.comparacionDeEstructurasREST(pathStructure, SerenityRest.lastResponse().asString());
    }

    public void validateStatusKey(String StatusKey, String expectedStatus){
        KrakenRest.compararLlave(StatusKey, expectedStatus);
    }


}
