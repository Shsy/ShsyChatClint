package com.shsy.shsychatclint.activity;

import android.support.design.widget.Snackbar;
import android.text.TextUtils;

import com.shsy.shsychatclint.NetConfig;
import com.shsy.shsychatclint.R;
import com.shsy.shsychatclint.abs.callback.ResultCallback;
import com.shsy.shsychatclint.base.BaseActivity;
import com.shsy.shsychatclint.base.ResultBean;
import com.shsy.shsychatclint.bean.LoginBean;
import com.shsy.shsychatclint.databinding.ActivityLoginBinding;
import com.shsy.shsychatclint.utils.ActivityUtil;
import com.shsy.shsychatclint.utils.RemindUtil;
import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.Call;

/**
 * Created by Shsy on 2016/12/22.
 * 这是登录页面
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initData() {
        mBinding.setBean(new LoginBean());
        mBinding.setPresenter(new Presenter());
    }

    @Override
    protected void doBusiness() {

    }

    public class Presenter {
        public void login(String username, String password) {
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                Snackbar.make(mBinding.getRoot(), "用户名或密码不能为空~", Snackbar.LENGTH_SHORT).show();
                return;
            }

            showLoading();
            OkHttpUtils.get()
                    .url(NetConfig.Url.LOGIN)
                    .addParams("username", username)
                    .addParams("password", password)
                    .build().execute(new ResultCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    dismissLoading();
                    RemindUtil.showToastShort(getApplicationContext(), "网络连接错误啊");
                }

                @Override
                public void onResponse(ResultBean response, int id) {
                    dismissLoading();
                    if (response.getStatus() == NetConfig.Status.OK) {
                        RemindUtil.showToastShort(getApplicationContext(), "登录成功");
                    } else {
                        RemindUtil.showToastShort(getApplicationContext(), response.getMsg());
                    }
                }
            });
        }

        public void regist() {
            ActivityUtil.startActivity(LoginActivity.this, RegistActivity.class);
        }
    }
}
