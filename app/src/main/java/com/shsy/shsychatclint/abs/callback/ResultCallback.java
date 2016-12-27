package com.shsy.shsychatclint.abs.callback;

import com.alibaba.fastjson.JSONObject;
import com.shsy.shsychatclint.bean.ResultBean;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * Created by Shsy on 2016/12/25.
 */

public abstract class ResultCallback extends Callback<ResultBean> {
    @Override
    public ResultBean parseNetworkResponse(Response response, int id) throws Exception {
        return JSONObject.parseObject(response.body().string(),ResultBean.class);
    }
}