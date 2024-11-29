package org.KPUIFramework.base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.KPUIFramework.endpoints.APIConstants;
import org.KPUIFramework.modules.LoginPayload;
import org.KPUIFramework.pojo.TokenResponsePojo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static org.KPUIFramework.endpoints.APIConstants.LOGINWITHMOBILE;
import static org.KPUIFramework.endpoints.APIConstants.VERIFYOTP;

public class BaseClass {
    public APIConstants apiConstants;
   static public RequestSpecification requestSpecification;
   static public Response response;
   protected static String actualToken;

//    @BeforeTest
    @BeforeClass
//    @Test
    public static String loginAndGenerateToken(){

        requestSpecification = RestAssured.given()
                                .baseUri(APIConstants.BASEURL)
                                .basePath(LOGINWITHMOBILE)
                                .contentType("application/json");
        response = RestAssured.given(requestSpecification)
                .when().body(LoginPayload.getLoginDetails()).post();

        String expectedToken = verifyOTP();
        return expectedToken;
    }

    public static String verifyOTP(){
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASEURL)
                .basePath(VERIFYOTP)
                .contentType("application/json");

        response = RestAssured.given(requestSpecification)
                .when().body(LoginPayload.getLoginDetails()).post();

//        response.then().log().all();

        assertThat(response.statusCode()).isEqualTo(201);
        assertThat(response.statusLine()).isEqualTo("HTTP/1.1 201 Created");
//        assertThat(response.getTime()).isLessThan(2000);
        assertThat(response.getContentType()).isEqualTo("application/json; charset=utf-8");

        TokenResponsePojo trrp = LoginPayload.getDeSerializedResponse(response.asString());
        String token = trrp.getAccessToken();

        System.out.printf("Generated token : "+token);

//        actualToken = token;
        return token;
    }
}
