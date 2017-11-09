package moe.eloli.tuzi.ui.user_topic_list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import moe.eloli.tuzi.HomelandApplication;
import moe.eloli.tuzi.R;
import moe.eloli.tuzi.di.component.DaggerUserTopicListComponent;
import moe.eloli.tuzi.di.module.UserTopicListModule;
import moe.eloli.tuzi.ui.base.BaseActivity;
import moe.eloli.tuzi.ui.user_profile.UserProfileActivity;

public class UserTopicListActivity extends BaseActivity {

    public static final String EXTRA_USER_TOPIC_LIST_TYPE = "EXTRA_USER_TOPIC_LIST_TYPE";

    private String mUserLoginName;
    private String mTopicListType;

    @Inject
    UserTopicListPresenter mUserTopicListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        mUserLoginName = getIntent().getStringExtra(UserProfileActivity.EXTRA_USER_LOGIN_NAME);
        mTopicListType = getIntent().getStringExtra(EXTRA_USER_TOPIC_LIST_TYPE);
        if (mUserLoginName == null || mTopicListType == null) {
            Toast.makeText(getApplicationContext(), "获取信息失败", Toast.LENGTH_SHORT).show();
            finish();
        }

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.contentBox);
        UserTopicListFragment userTopicListFragment = (UserTopicListFragment) fragment;

        if (userTopicListFragment == null) {
            userTopicListFragment = UserTopicListFragment.newInstance();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(R.id.contentBox, userTopicListFragment);
            transaction.commit();
        }

        DaggerUserTopicListComponent.builder()
                .basicComponent(((HomelandApplication) getApplication()).getBasicComponent())
                .userTopicListModule(new UserTopicListModule(mUserLoginName, mTopicListType, userTopicListFragment)).build()
                .inject(this);
    }

    @OnClick(R.id.btnBack)
    public void goBack() {
        finish();
    }
}
