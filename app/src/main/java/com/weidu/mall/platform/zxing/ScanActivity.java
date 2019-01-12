package com.weidu.mall.platform.zxing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.weidu.mall.platform.MainActivity;
import com.weidu.mall.platform.R;

public class ScanActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private ImageView scanIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        scanIv = findViewById(R.id.iv_scan);
    }

    /**
     * 扫描
     * @param view
     */
    public void scan(View view) {
        Intent intent = new Intent(ScanActivity.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(ScanActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    /**
     * 生成
     * @param view
     */
    public void product(View view) {
        Bitmap mBitmap = CodeUtils.createImage("我是谁", 400, 400, null);
        scanIv.setImageBitmap(mBitmap);
    }

    public void crash(View view) {
        int i = 10/0;
    }
}
