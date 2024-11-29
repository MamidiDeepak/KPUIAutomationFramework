package org.KPUIFramework.tests.individualTests;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import org.KPUIFramework.base.BaseClass;
import org.KPUIFramework.endpoints.APIConstants;
import org.KPUIFramework.listeners.ReTryAnalyzer;
import org.KPUIFramework.modules.CreateCustomerPayload;
import org.KPUIFramework.pojo.CreateCustomerResponsePojo;
import org.testng.annotations.Test;

public class CreateNewCustomer extends BaseClass {

        Gson gson = new Gson();

        String token = BaseClass.loginAndGenerateToken();
        
    @Test (retryAnalyzer = ReTryAnalyzer.class)
    public void testCreationOfCustomer(){

       requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASEURL)
                .basePath(APIConstants.CREATECUSTOMER)
                .header("Authorization","Bearer " +token)
                .contentType("application/json");

             response =  RestAssured.given(requestSpecification)
                        .when().body(CreateCustomerPayload.getCreateCustomerPayload()).post();

             response.then().log().all();

        CreateCustomerResponsePojo ccrpp = CreateCustomerPayload.getDeSerializedResponseData(response.asString());

        String customerEntity = ccrpp.getData().getEntityId();
        String customerId = ccrpp.getData().getId();
        System.out.println("Created Entity Id : "+customerEntity);
        System.out.printf("Created Customer Id : "+customerId);

    }
}
