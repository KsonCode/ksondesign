package com.weidu.mall.platform.model;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;
import com.example.lib_network.bean.BaseResponseBean;
import com.example.lib_network.network.RetrofitUtils;
import com.example.lib_network.network.RxUtils;
import com.weidu.mall.platform.api.ProductApi;
import com.weidu.mall.platform.api.ProductApiService;
import com.weidu.mall.platform.contract.ProductContract;
import com.weidu.mall.platform.entity.ProductBean;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class ProductModel implements ProductContract.IProductModel {

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

        RetrofitUtils.getInstance().createService(ProductApiService.class)
                .getProducts(new HashMap<String, String>())
                .compose(RxUtils.schdulers())
                .subscribe(new Observer<BaseResponseBean<List<ProductBean>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponseBean<List<ProductBean>> listBaseResponseBean) {
                        if (callback!=null){
                            callback.success(listBaseResponseBean.result);
                        }

                    }



                    @Override
                    public void onError(Throwable e) {


                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public interface IProductCallback{
        public void failure(String msg);

        public void success(List<ProductBean> result);
    }
}
