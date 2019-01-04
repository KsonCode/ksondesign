package com.weidu.mall.platform.model;

import com.example.lib_core.net.OkhttpCallback;
import com.example.lib_core.net.OkhttpUtils;
import com.weidu.mall.platform.api.ProductApi;
import com.weidu.mall.platform.contract.ProductContract;

import java.util.HashMap;

public class ProductModel implements ProductContract.IProductModel {

    @Override
    public void getProductList(HashMap<String, String> params, final IProductCallback callback) {
        OkhttpUtils.getInstance().doGet(ProductApi.PRODUCT_API, params, new OkhttpCallback() {
            @Override
            public void failure(String msg) {
                callback.failure(msg);

            }

            @Override
            public void success(String result) {
                callback.success(result);

            }
        });
    }

    public interface IProductCallback{
        public void failure(String msg);

        public void success(String result);
    }
}
