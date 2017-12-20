package com.example.ztz.zhangtianzhu1219_shopcart.view;

import com.example.ztz.zhangtianzhu1219_shopcart.bean.DeleteCartBean;

/**
 * Created by ztz on 2017/12/19.
 */

public interface DeleteCartViewCallBack {
    void success(DeleteCartBean deleteCartBean);
    void failed(String e);
}
