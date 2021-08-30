package io.swagger.petstore.test.steps;

import com.sqasa.rest.demo.utils.KrakenRest;
import net.serenitybdd.rest.SerenityRest;

import java.util.Map;

public class CreateUserSteps {



    public void sendRequest(String url, Map<String, String> body){
       KrakenRest.inicializarRequest();
       // KrakenRest.configurarCuerpo(body);
        SerenityRest.given().baseUri(url).header("Content-Type","application/json").body(body).post();
        SerenityRest.lastResponse().then().log().all();
        //KrakenRest.hacerPost(url);
    }

    public void validateStatus(int status){
        KrakenRest.compararStatus(status);
    }

    public void validateStructure(String pathStructure){
        KrakenRest.comparacionDeEstructurasREST(pathStructure, SerenityRest.lastResponse().asString());
    }

    public void validateType(String typeKey, String expectedType){
        KrakenRest.compararLlave(typeKey, expectedType);
    }

    public void validateMessage(String messageKey, String expectedMessage){
        KrakenRest.compararLlave(messageKey, expectedMessage);
    }
}
