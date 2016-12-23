package com.shsy.shsychatclint.activity;


import android.support.design.widget.Snackbar;
import android.view.View;

import com.shsy.shsychatclint.R;
import com.shsy.shsychatclint.base.BaseActivity;
import com.shsy.shsychatclint.bean.RegistBean;
import com.shsy.shsychatclint.databinding.ActivityRegistBinding;

/**
 * Created by Shsy on 2016/12/22.
 * 这是注册页面
 */
public class RegistActivity extends BaseActivity<ActivityRegistBinding> {
    @Override
    protected int bindLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initToolBar() {
        mBinding.toolbar.setTitle("相册");
        mBinding.toolbar.setNavigationIcon(R.mipmap.icon_back);
        setSupportActionBar(mBinding.toolbar);
        mBinding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        mBinding.setBean(new RegistBean());
        mBinding.setPresenter(new Presenter());
    }

    @Override
    protected void doBusiness() {

    }

    public class Presenter {
        public void getVerifycode(String phone) {
            Snackbar.make(mBinding.getRoot(), phone, Snackbar.LENGTH_SHORT).show();
        }

        public void regist(String username, String verifycode, String password) {
            Snackbar.make(mBinding.getRoot(), username+verifycode + password, Snackbar.LENGTH_SHORT).show();
        }
    }
}
