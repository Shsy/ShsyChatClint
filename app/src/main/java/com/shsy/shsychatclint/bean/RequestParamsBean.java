package com.shsy.shsychatclint.bean;

import java.util.TreeMap;

/**
 * Created by 申尚宇 on 2016/12/27.
 * 请求参数的类.
 */

public class RequestParamsBean<K, V> extends TreeMap<K, V> {

    public void putPublicParams() {
        this.put((K) "device", (V) "mobile");
    }


    public static class Builder {
        private RequestParamsBean<String, String> requestParamsBean = null;


        public Builder put(String key, String value) {
            if (requestParamsBean == null) {
                requestParamsBean = new RequestParamsBean<>();
            }
            requestParamsBean.put(key, value);
            return this;
        }

        public RequestParamsBean build() {
            return requestParamsBean;
        }
    }
}
