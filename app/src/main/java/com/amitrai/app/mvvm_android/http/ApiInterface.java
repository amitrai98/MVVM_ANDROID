package com.amitrai.app.mvvm_android.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by amitRai on 17/04/2017.
 * all apis for this app
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("/mindfulness/api/v1.0/app_getArticleDetails")
    Call<ResponseBody> getArticles(@Field("page") String page_no);

}
