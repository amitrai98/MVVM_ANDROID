package com.amitrai.app.mvvm_android.http;


import com.amitrai.app.mvvm_android.listeners.BaseListener;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by amitRai on 17/04/2017.
 * manages connections from web to app
 */

public class ConnectionManager  {
    private static final String STR_NO_CONNECTION ="Trouble reaching  server,No internet connection.";
    private static ConnectionManager mConnectionManger;
    private Call<ResponseBody> enqueueCall;

    public static ConnectionManager getConnectionInstance(Call<ResponseBody> call) {
        if (mConnectionManger == null) {
            mConnectionManger = new ConnectionManager();
            mConnectionManger.setEnqueueCall(call);
            return mConnectionManger;
        } else{
            mConnectionManger.setEnqueueCall(call);
            return mConnectionManger;
    }
   }

    private void setEnqueueCall(Call<ResponseBody> mCall) {

        this.enqueueCall = mCall;
    }


    public void callApi(final BaseListener.OnWebServiceCompleteListener mListener){
        this.enqueueCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.isSuccessful()){
                    mListener.onWebServiceComplete(response.body());
                }else{
                    //APIError error = ErrorUtils.parseError(response);
                    mListener.onWebStatusFalse(response.message());
                }

            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                if(t instanceof IOException){
                    mListener.onWebStatusFalse(ConnectionManager.STR_NO_CONNECTION);
                    return;
                }
                mListener.onWebStatusFalse(t.getMessage());
            }
        });
    }
}
