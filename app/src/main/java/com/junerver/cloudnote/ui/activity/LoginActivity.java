package com.junerver.cloudnote.ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.junerver.cloudnote.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.etLoginUsername)
    EditText mEtLoginUsername;
    @BindView(R.id.etLoginPassword)
    EditText mEtLoginPassword;
    @BindView(R.id.btnLogin)
    Button mBtnLogin;
    @BindView(R.id.tvRegister)
    TextView mTvRegister;
    @BindView(R.id.tvQuicklogin)
    TextView mTvQuicklogin;

    private String mLoginUsername;
    private String mLoginPassword;


    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.btnLogin, R.id.tvRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                mLoginUsername =mEtLoginUsername.getText().toString().trim();
                mLoginPassword =mEtLoginPassword.getText().toString().trim();
                //都不是空
                if (TextUtils.isEmpty(mLoginUsername)) {
                    mEtLoginUsername.requestFocus();
                    mEtLoginUsername.setError("对不起，用户名不能为空");
                    return;
                }
                if (TextUtils.isEmpty(mLoginPassword)){
                    mEtLoginPassword.requestFocus();
                    mEtLoginPassword.setError("对不起，用密码不能为空");
                    return;
                }
                // TODO: 2016/8/31  通过服务器验证 然后跳转页面

                break;
            case R.id.tvRegister:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }
}