package com.example.ztz.zhangtianzhu1219_shopcart.application;

import android.app.Application;

import com.example.ztz.zhangtianzhu1219_shopcart.api.API;
import com.facebook.drawee.backends.pipeline.Fresco;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ztz on 2017/12/19.
 */

public class MyApplication extends Application {

    public static API api;

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * Frosco初始化
         */
        Fresco.initialize(this);
        /**
         * retrofit初始化
         */
        Retrofit builder = new Retrofit.Builder()
                .baseUrl("http://120.27.23.105/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = builder.create(API.class);
    }
}
