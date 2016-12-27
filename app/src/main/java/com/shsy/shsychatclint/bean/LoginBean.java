package com.shsy.shsychatclint.bean;

import android.databinding.Bindable;

import com.shsy.shsychatclint.base.BaseBean;

/**
 * Created by Shsy on 2016/12/22.
 * 登录的数据
 */

public class LoginBean extends BaseBean {

    private String username;
    private String password;

    private String id;
    private String token;
    private String isLogin;
    private String isDelete;

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(com.shsy.shsychatclint.BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(com.shsy.shsychatclint.BR.password);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
