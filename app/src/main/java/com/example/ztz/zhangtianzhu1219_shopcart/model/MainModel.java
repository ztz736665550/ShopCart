package com.example.ztz.zhangtianzhu1219_shopcart.model;

import com.example.ztz.zhangtianzhu1219_shopcart.application.MyApplication;
import com.example.ztz.zhangtianzhu1219_shopcart.bean.ShopBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/19.
 */

public class MainModel {
    public void getData(final MainModelCallBack callBack){
        MyApplication.api.get("100","100","android")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ShopBean>() {
                    @Override
                    public void accept(ShopBean shopBean) throws Exception {
                        callBack.success(shopBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.failure(throwable.getMessage());
                    }
                });
    }
}
