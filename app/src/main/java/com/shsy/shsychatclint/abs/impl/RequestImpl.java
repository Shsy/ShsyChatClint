package com.shsy.shsychatclint.abs.impl;

import com.shsy.shsychatclint.abs.interfaces.Request;
import com.shsy.shsychatclint.bean.RequestParamsBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.callback.Callback;

/**
 * Created by 申尚宇 on 2016/12/27.
 * 网络请求实现.
 */

public class RequestImpl implements Request {
    public void get(String url, RequestParamsBean requestParamsBean, Callback callback) {
        GetBuilder getBuilder = OkHttpUtils.get().url(url);
        if (requestParamsBean != null) {
            for (Object key : requestParamsBean.keySet()) {
                getBuilder.addParams((String) key, (String) requestParamsBean.get(key));
            }
        }
        getBuilder.build().execute(callback);
    }

    @Override
    public void post(String url, RequestParamsBean<String, String> requestParamsBean, Callback callback) {
    }
}
