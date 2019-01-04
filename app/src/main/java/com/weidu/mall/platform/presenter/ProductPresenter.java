package com.weidu.mall.platform.presenter;

import android.graphics.ColorSpace;

import com.example.lib_core.net.OkhttpCallback;
import com.weidu.mall.platform.contract.ProductContract;
import com.weidu.mall.platform.model.ProductModel;

import java.util.HashMap;

public class ProductPresenter extends ProductContract.ProductPresenter {


    @Override
    public void getProductList(HashMap<String, String> params) {
        model.getProductList(params, new ProductModel.IProductCallback() {
            @Override
            public void failure(String msg) {
                view.failure(msg);
            }

            @Override
            public void success(String result) {
                view.success(result);
            }
        });
    }
}
