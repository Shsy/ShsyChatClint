package com.shsy.shsychatclint.activity;

import com.shsy.shsychatclint.AppConfig;
import com.shsy.shsychatclint.R;
import com.shsy.shsychatclint.base.BaseActivity;
import com.shsy.shsychatclint.bean.MainBean;
import com.shsy.shsychatclint.databinding.ActivityMainBinding;
import com.shsy.shsychatclint.utils.SPUtil;

/**
 * Created by 申尚宇 on 2016/12/27.
 * 主页
 */

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolBar() {
        mBinding.toolbar.setTitle("ShsyChat");
        setSupportActionBar(mBinding.toolbar);
    }

    @Override
    protected void initData() {
        mBinding.setBean(new MainBean());
        mBinding.setPresenter(new Presenter());
    }

    @Override
    protected void doBusiness() {
        SPUtil.put(mContext, AppConfig.SharedPreferences.IS_LOGIN, "1");
    }

    public class Presenter {

    }
}
