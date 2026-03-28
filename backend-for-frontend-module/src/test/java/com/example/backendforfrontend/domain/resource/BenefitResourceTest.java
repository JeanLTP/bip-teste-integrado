package com.example.backendforfrontend.domain.resource;

import com.example.backendforfrontend.BackendForFrontendApplication;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

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
}