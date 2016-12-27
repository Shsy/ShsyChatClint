package com.shsy.shsychatclint.activity;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;

import com.shsy.shsychatclint.AppConfig;
import com.shsy.shsychatclint.R;
import com.shsy.shsychatclint.abs.callback.ResultCallback;
import com.shsy.shsychatclint.base.BaseActivity;
import com.shsy.shsychatclint.bean.ResultBean;
import com.shsy.shsychatclint.bean.RegistBean;
import com.shsy.shsychatclint.databinding.ActivityRegistBinding;
import com.shsy.shsychatclint.utils.EncryptionUtil;
import com.shsy.shsychatclint.utils.RegexUtil;
import com.shsy.shsychatclint.utils.RemindUtil;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.Random;

import okhttp3.Call;

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
        mBinding.toolbar.setTitle("注册");
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

        private String verifycode = "0";

        public void regist(String username, String verifycode, String password) {
            if (TextUtils.isEmpty(username)) {
                RemindUtil.showToastShort(mContext, "为何手机号空空的...");
                return;
            }
            if (!RegexUtil.isPhone(username)) {
                RemindUtil.showToastShort(mContext, "输入正确的手机号哇..");
                return;
            }
            if (!TextUtils.equals(verifycode, this.verifycode)) {
                RemindUtil.showToastShort(mContext, "验证码不对哇..");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                RemindUtil.showToastShort(mContext, "密码不要空空的哇..");
                return;
            }
            password = EncryptionUtil.MD5(password);
            if (password == null) {
                RemindUtil.showToastShort(mContext, "加密出错请联系我");
            } else {
                realRegist(username, password);
            }
        }

        private void realRegist(String username, String password) {
            showLoading();
            OkHttpUtils.get().url(AppConfig.NetUrl.REGIST)
                    .addParams("username", username)
                    .addParams("password", password)
                    .build().execute(new ResultCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {
                    dismissLoading();
                    RemindUtil.showToastShort(mContext, "网络连接错误啊");
                }

                @Override
                public void onResponse(ResultBean response, int id) {
                    dismissLoading();
                    if (response.getStatus() == AppConfig.NetStatus.OK) {
                        RemindUtil.showToastShort(mContext, response.getMsg());
                        mActivity.finish();
                    } else {
                        RemindUtil.showToastShort(mContext, response.getMsg());
                    }
                }
            });
        }

        public void getVerifycode(String phone) {
            if (TextUtils.isEmpty(phone)) {
                RemindUtil.showToastShort(mContext, "为何手机号空空的...");
                return;
            }
            if (!RegexUtil.isPhone(phone)) {
                RemindUtil.showToastShort(mContext, "输入正确的手机号哇..");
                return;
            }
            verifycode = String.valueOf(1000 + new Random(System.currentTimeMillis()).nextInt(9000));
            new AlertDialog.Builder(mActivity)
                    .setTitle("验证码")
                    .setMessage(verifycode)
                    .setNegativeButton("好的", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        }
    }
}
