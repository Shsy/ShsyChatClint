package com.shsy.shsychatclint.utils;

/**
 * Created by 申尚宇 on 2016/12/23.
 * 正则表达式验证类
 */

public class RegexUtil {
    public static boolean isPhone(String phone) {
        return phone.matches("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
    }
}
