package com.example.material_design.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.material_design.R;
import com.example.material_design.Utils.ToastUtils;


/**
 * Created by user on 2017/3/13.
 */
public class LoginActivity extends Activity {
    private static final String TAG = "LoginActivity";
    private TextInputLayout mTilUsername;
    private EditText mUsername;
    private TextInputLayout mTilPassword;
    private EditText mPassword;
    private Button mLogin;
    private TextView mRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        initView();

    }

    private void initView() {
        mTilUsername = (TextInputLayout) findViewById(R.id.til_username);
        mUsername = (EditText) findViewById(R.id.username);
        mTilPassword = (TextInputLayout) findViewById(R.id.til_password);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        mRegister = (TextView) findViewById(R.id.register);
    }

    public void login(View view) {
        String userName = mTilUsername.getEditText().getText().toString().trim();
        String passWord = mTilPassword.getEditText().getText().toString().trim();
        if (userName.equals("") && passWord.equals("")) {
            ToastUtils.showToast(this,"登录失败");
        } else {
            ToastUtils.showToast(this,"登录成功");
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

    }

    public void register(View view) {
        ToastUtils.showToast(this,"蠢得像猪一样还想注册？");
        finish();
    }

    public void findPassword(View view) {
        ToastUtils.showToast(this,"蠢得像猪一样还想找回密码？");
    }

}
