package com.amitrai.app.mvvm_android.listeners;


import okhttp3.ResponseBody;

public interface BaseListener {

      interface OnWebServiceCompleteListener {

        void onWebServiceComplete(ResponseBody baseObject);

        // this method will fired when service status is false
        void onWebStatusFalse(String message);
    }
}