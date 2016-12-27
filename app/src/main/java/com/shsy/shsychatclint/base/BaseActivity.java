package com.shsy.shsychatclint.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 申尚宇 on 2016/10/19.
 * activity的基类
 */

public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    protected T mBinding;
    protected Context mContext;
    protected Activity mActivity;

    private ProgressDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        initToolBar();
        initData();
        doBusiness();
    }

    /**
     * 初始化操作
     */
    private void init() {
        mContext = this.getApplicationContext();
        mActivity = BaseActivity.this;
        int layoutId = bindLayoutId();
        if (layoutId == 0) throw new RuntimeException("LayoutId is 0...");
        mBinding = DataBindingUtil.setContentView(mActivity, layoutId);
    }

    /**
     * 显示正在加载的dialog
     */
    protected void showLoading() {
        mLoadingDialog = ProgressDialog.show(mActivity, null, "正在加载...");
    }

    /**
     * 隐藏正在加载的dialog
     */
    protected void dismissLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) mLoadingDialog.dismiss();
    }

    /**
     * 获取布局Layout
     *
     * @return 布局Layout
     */
    protected abstract int bindLayoutId();

    /**
     * 初始化ToolBar
     */
    protected abstract void initToolBar();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 业务操作
     */
    protected abstract void doBusiness();
}
