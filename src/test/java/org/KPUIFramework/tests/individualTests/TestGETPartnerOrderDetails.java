package org.KPUIFramework.tests.individualTests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.KPUIFramework.asserts.AssertClass;
import org.KPUIFramework.base.BaseClass;
import org.KPUIFramework.endpoints.APIConstants;
import org.KPUIFramework.listeners.ReTryAnalyzer;
import org.testng.annotations.Test;

public class TestGETPartnerOrderDetails extends BaseClass {

    Gson gson = new Gson();

    String token = BaseClass.loginAndGenerateToken();

    String orderId = "20caf7e1-5fa9-47a4-84b1-131449ffd5fb";

    @Test (retryAnalyzer = ReTryAnalyzer.class)
    public void testGetPartnerOrderDetails(){

        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASEURL)
                .basePath(APIConstants.GETORDERDETAILS+orderId)
                .header("Authorization","Bearer " +token)
                .contentType("application/json");

        response = RestAssured.given(requestSpecification)
                .when().get();

        response.then().log().all();

        AssertClass.testStatusCode(response.statusCode(),200);
        AssertClass.testStatusLine(response.statusLine(),"HTTP/1.1 200 OK");
        AssertClass.testResponseTime(response.getTime(),5000L);
        AssertClass.testContentType(response.getContentType(),"application/json; charset=utf-8");
    }
}
