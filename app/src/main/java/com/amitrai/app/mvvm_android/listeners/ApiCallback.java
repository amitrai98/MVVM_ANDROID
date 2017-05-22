package com.amitrai.app.mvvm_android.listeners;


import com.amitrai.app.mvvm_android.bean.BaseBean;

/**
 * Created by amit rai on 20/3/17.
 * callbacks for api
 */

public interface ApiCallback {
    void onRequestSuccess(BaseBean bean);
    void onRequestFailed(String message);
}
