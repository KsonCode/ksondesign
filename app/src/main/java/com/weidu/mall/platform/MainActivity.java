package com.weidu.mall.platform;

import android.support.v7.widget.LinearLayoutManager;

import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.weidu.mall.platform.adapter.ProductAdapter;
import com.weidu.mall.platform.contract.ProductContract;
import com.weidu.mall.platform.entity.ProductBean;
import com.weidu.mall.platform.presenter.ProductPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<ProductContract.IProductModel, ProductContract.ProductPresenter> implements ProductContract.IProductView {


    @BindView(R.id.rv)
    XRecyclerView rv;



//    @Override
//    protected void initData() {
//        super.initData();
////        HashMap<String,String> params = new HashMap<>();
//////        params.put("keywords","手机");
//////        params.put("page","1");
//        presenter.getProductList(new HashMap<String, String>());
//
//
//    }



    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(List<ProductBean.ProductItemBean> productBean) {

//        showToast(result);
//        SpUtils.getInstance().putSp("userId","1");
//        SpUtils.getInstance().putSp("sessionId","1767676767676767");

        ProductAdapter productAdapter = new ProductAdapter(productBean,this);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(productAdapter);





    }

    @Override
    public void keywordsEmpty(String error) {
        showToast(error);

    }

    @Override
    public BasePresenter initPresenter() {
        return new ProductPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void failure(String msg) {

        showToast(msg);

    }


    @Override
    protected void init() {
        presenter.getProductList(new HashMap<String, String>());
    }
}
