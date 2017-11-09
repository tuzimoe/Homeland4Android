package moe.eloli.tuzi.ui.user_user_list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import moe.eloli.tuzi.HomelandApplication;
import moe.eloli.tuzi.di.component.DaggerUserUserListComponent;
import moe.eloli.tuzi.di.module.UserUserListModule;
import moe.eloli.tuzi.ui.base.BaseActivity;
import moe.eloli.tuzi.ui.user_profile.UserProfileActivity;

public class UserUserListActivity extends BaseActivity {

    public static final String EXTRA_USER_USER_LIST_TYPE = "EXTRA_USER_USER_LIST_TYPE";

    private String mUserLoginName;
    private String mUserListType;

    @Inject
    UserUserListPresenter mUserUserListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(moe.eloli.tuzi.R.layout.activity_user);
        ButterKnife.bind(this);

        mUserLoginName = getIntent().getStringExtra(UserProfileActivity.EXTRA_USER_LOGIN_NAME);
        mUserListType = getIntent().getStringExtra(EXTRA_USER_USER_LIST_TYPE);
        if (mUserLoginName == null || mUserListType == null) {
            Toast.makeText(getApplicationContext(), "获取信息失败", Toast.LENGTH_SHORT).show();
            finish();
        }

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(moe.eloli.tuzi.R.id.contentBox);
        UserUserListFragment userUserListFragment = (UserUserListFragment) fragment;

        if (userUserListFragment == null) {
            userUserListFragment = UserUserListFragment.newInstance();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(moe.eloli.tuzi.R.id.contentBox, userUserListFragment);
            transaction.commit();
        }

        DaggerUserUserListComponent.builder()
                .basicComponent(((HomelandApplication) getApplication()).getBasicComponent())
                .userUserListModule(new UserUserListModule(mUserLoginName, mUserListType, userUserListFragment)).build()
                .inject(this);
    }

    @OnClick(moe.eloli.tuzi.R.id.btnBack)
    public void goBack() {
        finish();
    }
}
