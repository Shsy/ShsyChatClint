package com.shsy.shsychatclint.utils;

import com.shsy.shsychatclint.abs.impl.RequestImpl;
import com.shsy.shsychatclint.abs.interfaces.Request;
import com.shsy.shsychatclint.bean.RequestParamsBean;
import com.zhy.http.okhttp.callback.Callback;

/**
 * Created by 申尚宇 on 2016/12/27.
 * 网络工具
 */

public class HttpUtil {

    private static Request getRequest() {
        return new RequestImpl();
    }

    public static void get(String url, RequestParamsBean requestParamsBean, Callback callback) {
        getRequest().get(url, requestParamsBean, callback);
    }

    public static void post(String url, RequestParamsBean<String, String> requestParamsBean, Callback callback) {
        getRequest().post(url, requestParamsBean, callback);
    }
}
