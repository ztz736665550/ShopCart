package com.example.ztz.zhangtianzhu1219_shopcart.model;

import com.example.ztz.zhangtianzhu1219_shopcart.application.MyApplication;
import com.example.ztz.zhangtianzhu1219_shopcart.bean.DeleteCartBean;
import com.example.ztz.zhangtianzhu1219_shopcart.view.DeleteCartViewCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ztz on 2017/12/19.
 */

public class DeleteModel {
    public void getData(String pid, final DeleteCartViewCallBack deleteCartViewCallBack) {
        MyApplication.api.del("100",pid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DeleteCartBean>() {
                    @Override
                    public void accept(DeleteCartBean deleteCartBean) throws Exception {
                        deleteCartViewCallBack.success(deleteCartBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        deleteCartViewCallBack.failed(throwable.getMessage());
                    }
                });
    }
}
