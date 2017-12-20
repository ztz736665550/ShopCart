package com.example.ztz.zhangtianzhu1219_shopcart.view;

import com.example.ztz.zhangtianzhu1219_shopcart.bean.ShopBean;

/**
 * Created by ztz on 2017/12/19.
 */

public interface MainViewListener {
    void success(ShopBean bean);
    void failure(String e);
}
