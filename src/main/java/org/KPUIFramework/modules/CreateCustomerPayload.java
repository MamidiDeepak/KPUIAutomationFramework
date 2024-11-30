package org.KPUIFramework.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.KPUIFramework.pojo.CreateCustomerPojo;
import org.KPUIFramework.pojo.CreateCustomerResponsePojo;

public class CreateCustomerPayload {

    static Gson gson = new Gson();

    static Faker fakeData = new Faker();

    public static String getCreateCustomerPayload(){

        String fakeName = fakeData.name().firstName();
        String fakeMiddleName = fakeData.name().nameWithMiddle();
        String fakeEmail = fakeData.internet().emailAddress();
        String fakeMobileNumber = fakeData.phoneNumber().phoneNumber();
        String fakeDob = fakeData.date().birthday().toString();

        CreateCustomerPojo createCustomerPojo = new CreateCustomerPojo();
        createCustomerPojo.setFirstName(fakeName);
        createCustomerPojo.setMiddleName(fakeMiddleName);
        createCustomerPojo.setLastName("Bowler");
        createCustomerPojo.setEmail(fakeEmail);
        createCustomerPojo.setMobile("+91"+fakeMobileNumber);
        createCustomerPojo.setDob("1983-01-01");
        createCustomerPojo.setGender("MALE");

        String[] aadhaarDocs = {"03e02eba-7a9c-471d-b573-4ac338da0534","0f1c229b-4fa0-45c0-b6e2-992e63aa136e"};

        createCustomerPojo.setAadhaarDocIds(aadhaarDocs);

        String[] panDocs = {"03e02eba-7a9c-471d-b573-4ac338da0534","0f1c229b-4fa0-45c0-b6e2-992e63aa136e"};

        createCustomerPojo.setPanDocIds(panDocs);

        String[] utilityDocs = {"03e02eba-7a9c-471d-b573-4ac338da0534","0f1c229b-4fa0-45c0-b6e2-992e63aa136e"};

        createCustomerPojo.setUtilityBillDocIds(utilityDocs);

        createCustomerPojo.setPanNumber("AKKPK1234I");

        createCustomerPojo.setUtilityBillNumber("03e02eba-7a9c-471d-b573-4ac338da0534");

        createCustomerPojo.setAadhaarNumber("499033435670");

        createCustomerPojo.setGstn("36AKKPK1234B1Z4");

        createCustomerPojo.setEducationLevel1("GRADUATE");

        createCustomerPojo.setEducationLevel2("PRIMARY");

        createCustomerPojo.setPartnerId("3d7dd48a-5358-4a3b-b1c5-3234bdab5723"); //partner login :919290222202

        createCustomerPojo.setEntityId("14d74a2b-c9fc-4f13-8c51-597d70f0148d"); // Entity business Name : kedar jadhav pvt ltd

//        Convert the Payload to JSONPayload
        String createCustomerPayload = gson.toJson(createCustomerPojo);
        return createCustomerPayload;
    }

    public static CreateCustomerResponsePojo getDeSerializedResponseData(String response){
        CreateCustomerResponsePojo ccrp = gson.fromJson(response, CreateCustomerResponsePojo.class);
        return ccrp;
    }
}
