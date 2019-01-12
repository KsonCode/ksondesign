package com.weidu.mall.platform.presenter;

import com.google.gson.Gson;
import com.weidu.mall.platform.contract.ProductContract;
import com.weidu.mall.platform.entity.ProductBean;
import com.weidu.mall.platform.model.ProductModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
                    ProductBean productBean = new Gson().fromJson(result,ProductBean.class);
                    List<ProductBean.ProductItemBean> list = new ArrayList<>();

                    list.addAll(productBean.result.rxxp);//添加集合数据到当前集合内
                    list.addAll(productBean.result.pzsh);
                    list.addAll(productBean.result.mlss);

                    view.success(list);


//                if (productBean!=null){
//
//                    ProductItemBean productItemBean = new ProductItemBean();
//
//
//                    productItemBean.name = productBean.getResult().getRxxp().get(0).getName();
//
//                    productItemBean.id = productBean.getResult().getRxxp().get(0).getId();
//                    List<ProductItemBean.ProductItem> items = new ArrayList<>();
//
//                    for (ProductBean.ResultBean.RxxpBean.CommodityListBean commodityListBean : productBean.getResult().getRxxp().get(0).getCommodityList()) {
//                        ProductItemBean.ProductItem productItem = new ProductItemBean.ProductItem();
//                        productItem.commodityId = commodityListBean.getCommodityId();
//                        productItem.commodityName = commodityListBean.getCommodityName();
//                        productItem.masterPic = commodityListBean.getMasterPic();
//
//                        items.add(productItem);
//
//                    }
//                    productItemBean.commodityList = items;
//                    list.add(productItemBean);
//
//                    //第二条目
//                    productItemBean = new ProductItemBean();
//
//                    productItemBean.name = productBean.getResult().getPzsh().get(0).getName();
//
//                    productItemBean.id = productBean.getResult().getPzsh().get(0).getId();
//                    List<ProductItemBean.ProductItem> items2 = new ArrayList<>();
//
//                    for (ProductBean.ResultBean.PzshBean.CommodityListBeanX commodityListBean : productBean.getResult().getPzsh().get(0).getCommodityList()) {
//                        ProductItemBean.ProductItem productItem = new ProductItemBean.ProductItem();
//                        productItem.commodityId = commodityListBean.getCommodityId();
//                        productItem.commodityName = commodityListBean.getCommodityName();
//                        productItem.masterPic = commodityListBean.getMasterPic();
//
//                        items.add(productItem);
//
//                    }
//                    productItemBean.commodityList = items2;
//                    list.add(productItemBean);
//
//                    //第三条目
//                    productItemBean = new ProductItemBean();
//
//                    productItemBean.name = productBean.getResult().getMlss().get(0).getName();
//
//                    productItemBean.id = productBean.getResult().getMlss().get(0).getId();
//                    List<ProductItemBean.ProductItem> items3 = new ArrayList<>();
//
//                    for (ProductBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBean : productBean.getResult().getMlss().get(0).getCommodityList()) {
//                        ProductItemBean.ProductItem productItem = new ProductItemBean.ProductItem();
//                        productItem.commodityId = commodityListBean.getCommodityId();
//                        productItem.commodityName = commodityListBean.getCommodityName();
//                        productItem.masterPic = commodityListBean.getMasterPic();
//
//                        items.add(productItem);
//
//                    }
//                    productItemBean.commodityList = items3;
//                    list.add(productItemBean);
//
//                    view.success(list);
//                }

            }
        });
    }
}
