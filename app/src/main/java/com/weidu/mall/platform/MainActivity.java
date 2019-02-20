package com.weidu.mall.platform;

import android.support.v7.widget.LinearLayoutManager;

import com.example.lib_core.base.mvp.BaseMvpActivity;
import com.example.lib_core.base.mvp.BasePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.weidu.mall.platform.adapter.HomeAdapter;
import com.weidu.mall.platform.contract.HomeContract;
import com.weidu.mall.platform.entity.HomeBean;
import com.weidu.mall.platform.presenter.HomePresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseMvpActivity<HomeContract.IHomeModel, HomeContract.HomePresenter> implements HomeContract.IHomeView {


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
    public void success(List<HomeBean.ProductItemBean> productBean) {

//        showToast(result);
//        SpUtils.getInstance().putSp("userId","1");
//        SpUtils.getInstance().putSp("sessionId","1767676767676767");

        HomeAdapter productAdapter = new HomeAdapter(productBean,this);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(productAdapter);





    }

    @Override
    public void keywordsEmpty(String error) {
        showToast(error);

    }

    @Override
    public BasePresenter initPresenter() {
        return new HomePresenter();
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


    /**
     * 初始化数据
     */
    @Override
    protected void init() {
        HashMap<String,String> params = new HashMap<>();
        params.put("keyword","电脑");
        params.put("page","1");
        params.put("count","10");
        presenter.getProductList(params);
    }
}
