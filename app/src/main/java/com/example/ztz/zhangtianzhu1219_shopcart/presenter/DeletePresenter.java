package com.example.ztz.zhangtianzhu1219_shopcart.presenter;

import com.example.ztz.zhangtianzhu1219_shopcart.adapter.ShopAdapter;
import com.example.ztz.zhangtianzhu1219_shopcart.bean.DeleteCartBean;
import com.example.ztz.zhangtianzhu1219_shopcart.model.DeleteModel;
import com.example.ztz.zhangtianzhu1219_shopcart.view.DeleteCartViewCallBack;

/**
 * Created by ztz on 2017/12/20.
 */

public class DeletePresenter {

    private DeleteCartViewCallBack deleteCartViewCallBack;
    private final DeleteModel deleteModel;

    public DeletePresenter(DeleteCartViewCallBack deleteCartViewCallBack) {
        this.deleteCartViewCallBack = deleteCartViewCallBack;
        this.deleteModel = new DeleteModel();
    }

    public void getData(String pid) {
        deleteModel.getData(pid, new DeleteCartViewCallBack() {
            @Override
            public void success(DeleteCartBean deleteCartBean) {
                deleteCartViewCallBack.success(deleteCartBean);
            }

            @Override
            public void failed(String e) {
                deleteCartViewCallBack.failed(e);
            }
        });
    }
}
