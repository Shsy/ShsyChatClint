package com.shsy.shsychatclint.activity;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.shsy.shsychatclint.AppConfig;
import com.shsy.shsychatclint.R;
import com.shsy.shsychatclint.abs.callback.ResultCallback;
import com.shsy.shsychatclint.base.BaseActivity;
import com.shsy.shsychatclint.bean.RequestParamsBean;
import com.shsy.shsychatclint.bean.ResultBean;
import com.shsy.shsychatclint.bean.LoginBean;
import com.shsy.shsychatclint.databinding.ActivityLoginBinding;
import com.shsy.shsychatclint.utils.ActivityUtil;
import com.shsy.shsychatclint.utils.EncryptionUtil;
import com.shsy.shsychatclint.utils.HttpUtil;
import com.shsy.shsychatclint.utils.RemindUtil;
import com.shsy.shsychatclint.utils.SPUtil;

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
        if (TextUtils.equals("1", (CharSequence) SPUtil.get(mContext, AppConfig.SharedPreferences.IS_LOGIN, "0"))) {
            ActivityUtil.startActivityAndFinish(mActivity, MainActivity.class);
        }
    }

    public class Presenter {
        public void login(String username, String password) {
            if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                RemindUtil.showToastShort(mContext, "用户名或密码不能为空~");
                return;
            }

            showLoading();
            HttpUtil.get(AppConfig.NetUrl.LOGIN,
                    new RequestParamsBean.Builder()
                            .put("username", username)
                            .put("password", EncryptionUtil.MD5(password))
                            .build(),
                    new ResultCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            dismissLoading();
                            RemindUtil.showToastShort(mContext, "网络连接错误啊");
                        }

                        @Override
                        public void onResponse(ResultBean response, int id) {
                            dismissLoading();
                            if (response.getStatus() == AppConfig.NetStatus.OK) {
                                LoginBean loginbean = JSONObject.parseObject(response.getResult(), LoginBean.class);
                                SPUtil.put(mContext, AppConfig.SharedPreferences.USER_ID, loginbean.getId());
                                SPUtil.put(mContext, AppConfig.SharedPreferences.TOKEN, loginbean.getToken());
                                ActivityUtil.startActivityAndFinish(mActivity, MainActivity.class);
                            } else {
                                RemindUtil.showToastShort(mContext, response.getMsg());
                            }
                        }
                    });
        }

        public void regist() {
            ActivityUtil.startActivity(mActivity, RegistActivity.class);
        }
    }
}
