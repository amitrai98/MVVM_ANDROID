package com.amitrai.app.mvvm_android.vms;

import android.databinding.BaseObservable;
import android.util.Log;

import com.amitrai.app.mvvm_android.bean.UserBean;

/**
 * Created by amitrai on 22/5/17.
 * this class is used for :-
 */

public class ClickHandler extends BaseObservable {
    private final String TAG = getClass().getSimpleName();
    public void onLoginClick(UserBean bean){
        Log.e("actual class", "user name : "+bean.getUsername()+" pass : "+bean.getPassword());
    }
}
