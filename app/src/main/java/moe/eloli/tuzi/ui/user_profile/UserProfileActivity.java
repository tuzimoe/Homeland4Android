package moe.eloli.tuzi.ui.user_profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import moe.eloli.tuzi.HomelandApplication;
import moe.eloli.tuzi.R;
import moe.eloli.tuzi.di.component.DaggerUserProfileComponent;
import moe.eloli.tuzi.di.module.UserProfileModule;
import moe.eloli.tuzi.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserProfileActivity extends BaseActivity {

    public static final String EXTRA_USER_LOGIN_NAME = "EXTRA_USER_LOGIN_NAME";

    private String mUserLoginName;

    @Inject
    UserProfilePresenter mUserProfilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        mUserLoginName = getIntent().getStringExtra(EXTRA_USER_LOGIN_NAME);
        if (mUserLoginName == null) {
            Toast.makeText(getApplicationContext(), "获取用户信息失败", Toast.LENGTH_SHORT).show();
            finish();
        }

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.contentBox);
        UserProfileFragment userProfileFragment = (UserProfileFragment) fragment;

        if (userProfileFragment == null) {
            userProfileFragment = UserProfileFragment.newInstance();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(R.id.contentBox, userProfileFragment);
            transaction.commit();
        }

        DaggerUserProfileComponent.builder()
                .basicComponent(((HomelandApplication) getApplication()).getBasicComponent())
                .userProfileModule(new UserProfileModule(mUserLoginName, userProfileFragment)).build()
                .inject(this);
    }

    @OnClick(R.id.btnBack)
    public void goBack() {
        finish();
    }
}
