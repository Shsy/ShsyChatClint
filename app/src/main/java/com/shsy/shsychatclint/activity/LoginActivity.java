package com.shsy.shsychatclint.activity;

import android.support.design.widget.Snackbar;
import android.text.TextUtils;

import com.shsy.shsychatclint.R;
import com.shsy.shsychatclint.base.BaseActivity;
import com.shsy.shsychatclint.bean.LoginBean;
import com.shsy.shsychatclint.databinding.ActivityLoginBinding;
import com.shsy.shsychatclint.utils.ActivityUtil;

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
            Snackbar.make(mBinding.getRoot(), "登录", Snackbar.LENGTH_SHORT).show();
        }

        public void regist() {
            ActivityUtil.startActivity(LoginActivity.this, RegistActivity.class);
        }
    }
}
