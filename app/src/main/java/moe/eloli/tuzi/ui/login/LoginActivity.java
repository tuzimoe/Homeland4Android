package moe.eloli.tuzi.ui.login;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import moe.eloli.tuzi.HomelandApplication;
import moe.eloli.tuzi.R;
import moe.eloli.tuzi.di.component.DaggerLoginComponent;
import moe.eloli.tuzi.di.module.LoginModule;
import moe.eloli.tuzi.ui.base.BaseActivity;
import moe.eloli.tuzi.ui.topics.TopicsActivity;
import moe.eloli.tuzi.util.AppConstant;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    @Inject
    LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        DaggerLoginComponent.builder()
                .basicComponent(((HomelandApplication) getApplication()).getBasicComponent())
                .loginModule(new LoginModule(this)).build()
                .inject(this);

        Uri uri = getIntent().getData();
        if (uri != null) {
            String code = uri.getQueryParameter("code");
            mPresenter.LoginByAuthCode(code);
        }
    }

    @OnClick(R.id.btnLoginByAuthCode)
    public void LoginByAuthCode() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri loginUrl = Uri.parse(AppConstant.OAUTH_LOGIN_URI);
        intent.setData(loginUrl);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.finish();
    }

    @Override
    public void finishActivity() {
        Intent intent = new Intent(getContext(), TopicsActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {}

    @Override
    public void showLoading() {}

    @Override
    public void showError() {}

    @Override
    public void hideFeedbackBox() {}

    @Override
    public void showMessage(String msg) {}
}
