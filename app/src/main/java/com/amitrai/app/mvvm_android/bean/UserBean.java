package com.amitrai.app.mvvm_android.bean;

import android.databinding.BaseObservable;

/**
 * Created by amitrai on 22/5/17.
 * this class is used for :-
 */

public class UserBean extends BaseObservable{
    String username;
    String password;

    public UserBean(String username,
            String password){
        this.username = username;
        this.password =password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
