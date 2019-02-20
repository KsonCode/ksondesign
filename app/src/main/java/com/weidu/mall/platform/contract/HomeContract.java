package com.weidu.mall.platform.contract;

import com.example.lib_core.base.mvp.BasePresenter;
import com.example.lib_core.base.mvp.IBaseModel;
import com.example.lib_core.base.mvp.IBaseView;
import com.weidu.mall.platform.entity.HomeBean;
import com.weidu.mall.platform.model.HomeModel;

import java.util.HashMap;
import java.util.List;

/**
 * 商品相关契约类
 */
public interface HomeContract {

     abstract class HomePresenter extends BasePresenter<IHomeModel,IHomeView>{



        public abstract void getProductList(HashMap<String, String> params);
        public abstract void getProductDetail(HashMap<String, String> params);

         @Override
         public IHomeModel getModel() {
             return new HomeModel();
         }
     }

    interface IHomeModel extends IBaseModel{

        void getProductList(HashMap<String,String> params, HomeModel.IProductCallback callback);

    }

    interface IHomeView extends IBaseView{

        void success(List<HomeBean.ProductItemBean> list);
        void keywordsEmpty(String error);

    }
}
