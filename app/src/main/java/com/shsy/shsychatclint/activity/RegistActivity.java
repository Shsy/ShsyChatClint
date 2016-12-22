package com.shsy.shsychatclint.activity;


import com.shsy.shsychatclint.R;
import com.shsy.shsychatclint.base.BaseActivity;
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

    }

    @Override
    protected void initData() {
        mBinding.setPresenter(new Presenter());
    }

    @Override
    protected void doBusiness() {

    }

    public class Presenter {
    }
}
