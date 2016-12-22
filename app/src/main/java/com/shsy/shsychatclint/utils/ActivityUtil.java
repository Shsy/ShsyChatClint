package com.shsy.shsychatclint.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Shsy on 2016/12/22.
 * 关于activity的工具类
 */

public class ActivityUtil {

    public static void startActivity(Activity act, Class cls) {
        act.startActivity(new Intent(act, cls));
    }
}
