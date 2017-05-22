package com.amitrai.app.mvvm_android.http;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amitRai on 17/04/2017.
 * for making requests using retrofit
 */
public class ApiBuilder {

    public static final String BASE_URL = "192.168.1.91";

    private static Retrofit retrofit;
    private static OkHttpClient.Builder okHttpClient =
            new OkHttpClient.Builder();
    public static ApiInterface createApiBuilder(){
         setLogInterCeptor();
        ApiInterface apiInterface;
        if(retrofit!=null){
             return retrofit.create(ApiInterface.class);
         }else {
             retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                     // set the okhttpclient and add default connect and read timepouts
                     .client(okHttpClient.connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build())
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
             apiInterface = retrofit.create(ApiInterface.class);
             return apiInterface;
         }
    }
    /**
     * set log interceptor for logging the network response
     */
    private static  void setLogInterCeptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.addInterceptor(interceptor).build();
    }

}
