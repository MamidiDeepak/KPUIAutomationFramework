package org.KPUIFramework.modules;

import com.google.gson.Gson;
import org.KPUIFramework.pojo.LoginPojo;
import org.KPUIFramework.pojo.TokenResponsePojo;

public class LoginPayload {

    static Gson gson = new Gson();

    public static LoginPojo getLoginDetails(){

        LoginPojo loginPojo = new LoginPojo();
        loginPojo.setType("MOBILE");
        loginPojo.setIdentifier("+919290222202");
        loginPojo.setOtp("123456");

//        Convert the payload to json payload
//        String jsonPayload = gson.toJson(loginPojo);
////        System.out.printf("requesting payload data : "+jsonPayload);
//        return jsonPayload;
        return loginPojo;
    }

    public static TokenResponsePojo getDeSerializedResponse(String response){
        TokenResponsePojo trp = gson.fromJson(response, TokenResponsePojo.class);
        return trp;
    }
}
