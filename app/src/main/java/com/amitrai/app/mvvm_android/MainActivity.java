package com.amitrai.app.mvvm_android;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amitrai.app.mvvm_android.bean.UserBean;
import com.amitrai.app.mvvm_android.databinding.ContentMainBinding;
import com.amitrai.app.mvvm_android.vms.ClickHandler;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ContentMainBinding binding = DataBindingUtil.setContentView(this, R.layout.content_main);

        UserBean userBean = new UserBean("mUser", "myPassword");
        binding.setUser(userBean);
        binding.setHandler(new ClickHandler());

    }
}
