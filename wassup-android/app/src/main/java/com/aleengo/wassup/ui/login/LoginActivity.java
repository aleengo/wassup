package com.aleengo.wassup.ui.login;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.aleengo.peach.toolbox.ui.BaseActivity;
import com.aleengo.wassup.R;

import androidx.annotation.NonNull;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity {

    private LoginPresenter mLoginPresenter;
    private LoginView mLoginView;

    @Override
    public String logTag() {
        return "LoginActivity";
    }

    @Override
    public View getLayoutView() {
        return mLoginView.uiView();
    }

    @Override
    public void daggerConfiguration() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mLoginView.init();

        mLoginPresenter = new LoginPresenter();
        mLoginPresenter.attach(mLoginView);
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == LoginView.REQUEST_READ_CONTACTS) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mLoginView.populateAutoComplete();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginView.clear();
        mLoginPresenter.detach();

        mLoginView = null;
        mLoginPresenter = null;
    }
}

