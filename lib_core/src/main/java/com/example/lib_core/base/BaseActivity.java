package com.example.lib_core.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.lib_core.utils.LogUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private boolean isStatus;//沉浸式
    private boolean isFullScreen;//全屏
    private Unbinder unbinder;

//    @Override
//    public void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState, @androidx.annotation.Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
    }


    protected abstract void initData();

    protected abstract void initView();


    /**
     * 绑定根布局id
     *
     * @return
     */
    protected abstract int bindLayoutId();

    /**
     * 显示toast
     *
     * @param msg
     */
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 无参跳转
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    /**
     * 有参跳转
     *
     * @param clz
     */
    public void startActivity(Bundle bundle, Class<?> clz) {
        Intent intent = new Intent(this, clz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     *
     * @param status
     */
    public void isStatus(boolean status){
        if (status){
            //沉浸式代码
        }
    }
    /**
     *全屏
     * @param
     */
    public void isFullscreen(boolean fullscreenn){
        if (fullscreenn){
            //全屏代码
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.d("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.d("onReStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();//解绑butterkinife
        }
    }
}
