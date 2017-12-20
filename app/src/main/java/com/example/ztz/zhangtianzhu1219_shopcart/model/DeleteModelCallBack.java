package com.example.ztz.zhangtianzhu1219_shopcart.model;

import com.example.ztz.zhangtianzhu1219_shopcart.bean.DeleteCartBean;

/**
 * Created by ztz on 2017/12/19.
 */

public interface DeleteModelCallBack {
    void success(DeleteCartBean deleteCartBean);
    void failed(String e);
}
