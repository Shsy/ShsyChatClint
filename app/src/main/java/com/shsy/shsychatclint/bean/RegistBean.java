package com.shsy.shsychatclint.bean;

import android.databinding.Bindable;

import com.shsy.shsychatclint.BR;
import com.shsy.shsychatclint.base.BaseBean;

/**
 * Created by 申尚宇 on 2016/12/23.
 * 注册的数据
 */

public class RegistBean extends BaseBean {
    private String username;
    private String password;
    private String verifycode;

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
        notifyPropertyChanged(BR.verifycode);
    }
}
