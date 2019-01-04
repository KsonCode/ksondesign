package com.example.lib_core.base.mvp;

import com.example.lib_core.base.BaseActivity;

public abstract class BaseMvpActivity<M extends IBaseModel,P extends BasePresenter> extends BaseActivity implements IBaseView {
    public M model;
    public P presenter;
    @Override
    protected void initData() {

        presenter = (P) initPresenter();
        if (presenter!=null){
            model = (M) presenter.getModel();
            if (model!=null){
                //绑定
                presenter.attach(model,this);

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            //解绑
            presenter.dettach();
        }
    }
}
