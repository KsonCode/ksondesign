package com.example.lib_network.network;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * rxjava管理：对rxjava所有功能管理
 */
public class RxUtils {

    /**
     * 把没有切换线程功能的observable对象，转换成切换过的observable对象
     * @return
     */
    public static ObservableTransformer schdulers(){
        return new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}
