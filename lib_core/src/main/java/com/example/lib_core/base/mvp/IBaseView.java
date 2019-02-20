package com.example.lib_core.base.mvp;

/**
 * base view
 */
public interface IBaseView {

    BasePresenter initPresenter();//初始化presennter方法

    void showLoading();//显示加载框

    void hideLoading();//隐藏加载框

    void failure(String msg);//请求失败
}
