package com.weidu.mall.platform.presenter;

import com.weidu.mall.platform.contract.HomeContract;
import com.weidu.mall.platform.entity.HomeBean;
import com.weidu.mall.platform.model.HomeModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomePresenter extends HomeContract.HomePresenter {


    @Override
    public void getProductList(HashMap<String, String> params) {
        model.getProductList(params, new HomeModel.IProductCallback() {
            @Override
            public void failure(String msg) {
                view.failure(msg);
            }

            @Override
            public void success(HomeBean.Product result) {
//                    HomeBean productBean = new Gson().fromJson(result,HomeBean.class);
                    List<HomeBean.ProductItemBean> list = new ArrayList<>();

                    list.addAll(result.rxxp);//添加集合数据到当前集合内
                    list.addAll(result.pzsh);
                    list.addAll(result.mlss);

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
//                    for (HomeBean.ResultBean.RxxpBean.CommodityListBean commodityListBean : productBean.getResult().getRxxp().get(0).getCommodityList()) {
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
//                    for (HomeBean.ResultBean.PzshBean.CommodityListBeanX commodityListBean : productBean.getResult().getPzsh().get(0).getCommodityList()) {
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
//                    for (HomeBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBean : productBean.getResult().getMlss().get(0).getCommodityList()) {
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

    /**
     * 商品详情接口
     * @param params
     */
    @Override
    public void getProductDetail(HashMap<String, String> params) {

    }
}
