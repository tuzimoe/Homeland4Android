package moe.eloli.tuzi.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import moe.eloli.tuzi.HomelandApplication;
import moe.eloli.tuzi.di.component.DaggerProfileComponent;
import moe.eloli.tuzi.di.module.ProfileModule;
import moe.eloli.tuzi.ui.base.BaseActivity;

public class ProfileActivity extends BaseActivity {

    @Inject
    ProfilePresenter mProfilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(moe.eloli.tuzi.R.layout.activity_profile);
        ButterKnife.bind(this);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(moe.eloli.tuzi.R.id.contentBox);
        ProfileFragment profileFragment = (ProfileFragment) fragment;

        if (profileFragment == null) {
            profileFragment = ProfileFragment.newInstance();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(moe.eloli.tuzi.R.id.contentBox, profileFragment);
            transaction.commit();
        }

        DaggerProfileComponent.builder()
                .basicComponent(((HomelandApplication) getApplication()).getBasicComponent())
                .profileModule(new ProfileModule(profileFragment)).build()
                .inject(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            mProfilePresenter.start();
        }
    }

    @OnClick(moe.eloli.tuzi.R.id.btnBack)
    public void goBack() {
        finish();
    }
}
