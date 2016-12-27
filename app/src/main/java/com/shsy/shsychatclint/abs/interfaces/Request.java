package com.shsy.shsychatclint.abs.interfaces;

import com.shsy.shsychatclint.bean.RequestParamsBean;
import com.zhy.http.okhttp.callback.Callback;

/**
 * Created by 申尚宇 on 2016/12/27.
 * 网络请求顶层接口
 */

public interface Request {
    void get(String url, RequestParamsBean requestParamsBean, Callback callback);

    void post(String url, RequestParamsBean<String, String> requestParamsBean, Callback callback);
}
