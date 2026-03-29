package com.example.bff.domain.resource;

import com.example.bff.BackendForFrontendApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@ConfigureWireMock(filesUnderClasspath = "wiremock")
@EnableWireMock
@SpringBootTest(
        classes = BackendForFrontendApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class BenefitResourceTest {

    @Value("${local.server.port}")
    private int port;

    @DisplayName("Dada uma consulta pelos beneficios cadastrados, " +
            "quando houverem beneficios cadastrados, " +
            "então deve retornar uma lista com todos os benefícios.")
    @Test
    void givenBenefitsSearchWhenExistsShouldReturn(){
        given()
                .port(port)
                .get("/api/v1/benefits")
                .then()
                .statusCode(200)
                .body("$", hasSize(2))
                .body("[0].name", equalTo("Carteira Principal"))
                .body("[0].description", equalTo("Saldo disponível para transferências"))
                .body("[0].value", equalTo(2000))
                .body("[1].name", equalTo("Carteira Reserva"))
                .body("[1].description", equalTo("Saldo de reserva"))
                .body("[1].value", equalTo(800));
    }

    @DisplayName("Dada uma consulta por um benefício específico, " +
            "quando o beneficio existir, " +
            "então deve retornar o benefício.")
    @Test
    void givenBenefitsSearchByIdWhenExistsShouldReturn(){
        Long benefitId = 1L;
        given()
                .port(port)
                .pathParam("id", benefitId)
                .get("/api/v1/benefits/{id}")
                .then()
                .statusCode(200)
                .body("name", equalTo("Carteira Principal"))
                .body("description", equalTo("Saldo disponível para transferências"))
                .body("value", equalTo(2000));
    }

    @Test
    @DisplayName("Dada a criação de um benefício, " +
            "quando for criado com sucesso, " +
            "então deve retornar o id do benefício criado.")
    void givenCreateABenefitWhenSucccessShouldReturnId() {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Carteira Teste");
        requestBody.put("description", "Teste");
        requestBody.put("value", 4000);
        requestBody.put("active", true);

        given()
                .port(port)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v1/benefits")
                .then()
                .statusCode(201)
                .body("id", equalTo(4));
    }

    @Test
    @DisplayName("Dado uma consulta por ID, " +
            "quando o benefício não existir, " +
            "então deve retornar 404 com mensagem de erro")
    void givenSearchByIdWhenNotExistsShouldReturn404() {
        Long benefitId = 99L;
        given()
                .port(port)
                .when()
                .pathParam("id", benefitId)
                .get("/api/v1/benefits/{id}")
                .then()
                .statusCode(404)
                .body("status", equalTo(404))
                .body("error", equalTo("Not Found"))
                .body("message", containsString("Benefício não encontrado"))
                .body("timestamp", notNullValue());
    }


}