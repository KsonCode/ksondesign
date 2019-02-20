package com.weidu.mall.platform.api;



import com.example.lib_network.bean.BaseResponseBean;
import com.weidu.mall.platform.entity.ProductBean;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ProductApiService {

    @GET("")
    Observable<BaseResponseBean<List<ProductBean>>> getProducts(@QueryMap HashMap<String,String> parms);
}
