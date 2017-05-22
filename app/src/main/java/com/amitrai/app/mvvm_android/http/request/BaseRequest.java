package com.amitrai.app.mvvm_android.http.request;

import com.amitrai.app.mvvm_android.http.ApiBuilder;
import com.amitrai.app.mvvm_android.http.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by amitRai on 17/04/2017.
 * base request type for all apis
 */
class BaseRequest {

    String DATA="data";
    String MESSAGE="message";
    String STATUS="status";

    ApiInterface getAPIClient(){
        return  ApiBuilder.createApiBuilder();

    }

    Gson getGsonBuilder(){
       Gson gson= new GsonBuilder().create();
       gson.serializeNulls();
        return gson;
    }
}
