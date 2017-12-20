package com.example.ztz.zhangtianzhu1219_shopcart.api;

import com.example.ztz.zhangtianzhu1219_shopcart.bean.DeleteCartBean;
import com.example.ztz.zhangtianzhu1219_shopcart.bean.ShopBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ztz on 2017/12/19.
 */

public interface API {
    @GET("product/getCarts")
    Observable<ShopBean> get(@Query("uid") String uid, @Query("pid")String pid, @Query("source")String source);

    @GET("product/deleteCart")
    Observable<DeleteCartBean> del(@Query("uid") String uid, @Query("pid")String pid, @Query("source")String source);


}
