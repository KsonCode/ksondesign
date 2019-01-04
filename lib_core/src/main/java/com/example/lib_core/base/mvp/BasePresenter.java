package com.example.lib_core.base.mvp;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<M,V> {



    public M model;
    public V view;
    private WeakReference<V> weakReference;

    public abstract M getModel();

    //绑定
    public void attach(M model,V view){
        this.model = model;
//        this.view = view;
        weakReference = new WeakReference<>(view);
        this.view = weakReference.get();//得到view
    }


    //解绑
    public void dettach(){
//        if (view!=null){
//            view = null;
//        }
        if (weakReference!=null){
            weakReference.clear();//清空对象
            weakReference =null;
            this.view = null;
        }
    }

}
