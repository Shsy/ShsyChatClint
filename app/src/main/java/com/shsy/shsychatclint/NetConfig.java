package com.shsy.shsychatclint;

/**
 * Created by Shsy on 2016/12/25.
 * 一些相关的配置信息
 */

public final class NetConfig {
    /**
     * 关于网络请求的URL
     */
    public static final class Url {
        private static final String URL = "http://xn--rss51edx5awol.xn--5gq533gbta.xn--6qq986b3xl/api/";

        public static final String LOGIN = URL + "user/login";
        public static final String REGIST = URL + "user/regist";
        public static final String LOGOUT = URL + "user/logout";
    }

    /**
     * 关于网络请求状态码
     */
    public static final class Status {
        public static final int OK = 0;
    }
}
