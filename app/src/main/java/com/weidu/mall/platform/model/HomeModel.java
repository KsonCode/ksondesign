package com.weidu.mall.platform.model;

import com.example.lib_network.bean.BaseResponseBean;
import com.example.lib_network.network.HttpObserver;
import com.example.lib_network.network.RetrofitUtils;
import com.example.lib_network.network.RxUtils;
import com.weidu.mall.platform.api.HomeApiService;
import com.weidu.mall.platform.contract.HomeContract;
import com.weidu.mall.platform.entity.HomeBean;

import java.util.HashMap;

public class HomeModel implements HomeContract.IHomeModel {

    @Override
    public void getProductList(HashMap<String, String> params, final IProductCallback callback) {
//        OkhttpUtils.getInstance().doGet(ProductApi.PRODUCT_API, params, new OkhttpCallback() {
//            @Override
//            public void failure(String msg) {
//                callback.failure(msg);
//
//            }
//
//            @Override
//            public void success(String result) {
//                callback.success(result);
//
//            }
//        });

        RetrofitUtils.getInstance().createService(HomeApiService.class)
                .getProducts(params)
                .compose(RxUtils.<BaseResponseBean<HomeBean.Product>>schdulers())
                .subscribe(new HttpObserver<BaseResponseBean<HomeBean.Product>>() {
                    @Override
                    public void onSuccess(BaseResponseBean<HomeBean.Product> response) {
                        if (callback!=null){
                            callback.success(response.result);
                        }
                    }
                });


    }

    public interface IProductCallback{
        public void failure(String msg);

        public void success(HomeBean.Product result);
    }
}
