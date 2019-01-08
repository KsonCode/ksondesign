package com.example.lib_core.interceptor;

import com.example.lib_core.utils.SpUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();//请求对象，原始请求对象，用户名密码

        Request.Builder builder = request.newBuilder();
        //
        builder.addHeader("userId",SpUtils.getInstance().getSp("userId"));
        builder.addHeader("sessionId",SpUtils.getInstance().getSp("sessionId"));
        Request nrequest = builder.build();//修改过的request对象

        Response response = chain.proceed(nrequest);//响应对象
        return response;
    }
}
