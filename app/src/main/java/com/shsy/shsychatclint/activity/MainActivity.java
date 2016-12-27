package com.shsy.shsychatclint.activity;

import com.shsy.shsychatclint.AppConfig;
import com.shsy.shsychatclint.R;
import com.shsy.shsychatclint.abs.callback.ResultCallback;
import com.shsy.shsychatclint.base.BaseActivity;
import com.shsy.shsychatclint.bean.MainBean;
import com.shsy.shsychatclint.bean.RequestParamsBean;
import com.shsy.shsychatclint.bean.ResultBean;
import com.shsy.shsychatclint.databinding.ActivityMainBinding;
import com.shsy.shsychatclint.utils.ActivityUtil;
import com.shsy.shsychatclint.utils.HttpUtil;
import com.shsy.shsychatclint.utils.RemindUtil;
import com.shsy.shsychatclint.utils.SPUtil;

import okhttp3.Call;

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
        /**
         * 退出登录
         */
        public void logout() {
            showLoading();
            final String uid = (String) SPUtil.get(mContext, AppConfig.SharedPreferences.USER_ID, "");
            HttpUtil.get(AppConfig.NetUrl.LOGOUT, new RequestParamsBean.Builder().put("uid", uid).build(), new ResultCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    requestError();
                }

                @Override
                public void onResponse(ResultBean response, int id) {
                    dismissLoading();
                    RemindUtil.showSnackbarShort(mBinding.getRoot(), response.getMsg());
                    if (response.getStatus() == AppConfig.NetStatus.OK) {
                        SPUtil.put(mContext, AppConfig.SharedPreferences.IS_LOGIN, "0");
                        ActivityUtil.startActivityAndFinish(mActivity, LoginActivity.class);
                    }
                }
            });
        }
    }
}
