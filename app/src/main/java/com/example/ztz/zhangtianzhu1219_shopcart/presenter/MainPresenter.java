package com.example.ztz.zhangtianzhu1219_shopcart.presenter;

import com.example.ztz.zhangtianzhu1219_shopcart.MainActivity;
import com.example.ztz.zhangtianzhu1219_shopcart.bean.ShopBean;
import com.example.ztz.zhangtianzhu1219_shopcart.model.MainModel;
import com.example.ztz.zhangtianzhu1219_shopcart.model.MainModelCallBack;
import com.example.ztz.zhangtianzhu1219_shopcart.view.MainViewListener;

/**
 * Created by ztz on 2017/12/20.
 */

public class MainPresenter {

    private MainViewListener mainViewListener;
    private final MainModel mainModel;

    public MainPresenter(MainViewListener mainViewListener) {
        this.mainViewListener = mainViewListener;
        this.mainModel = new MainModel();
    }

    public void getData() {
        mainModel.getData(new MainModelCallBack() {
            @Override
            public void success(ShopBean bean) {
                mainViewListener.success(bean);
            }

            @Override
            public void failure(String e) {
                mainViewListener.failure(e);
            }
        });
    }
    /**
     * 防止内存泄漏
     */
    public void detach(){
        mainViewListener = null;
    }
}
