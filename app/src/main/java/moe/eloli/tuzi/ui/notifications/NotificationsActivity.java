package moe.eloli.tuzi.ui.notifications;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import moe.eloli.tuzi.HomelandApplication;
import moe.eloli.tuzi.R;
import moe.eloli.tuzi.di.component.DaggerNotificationsComponent;
import moe.eloli.tuzi.di.module.NotificationsModule;
import moe.eloli.tuzi.ui.base.AlertDialogCaller;
import moe.eloli.tuzi.ui.base.BaseActivity;
import moe.eloli.tuzi.util.AlertDialogUtil;

public class NotificationsActivity extends BaseActivity implements AlertDialogCaller {

    @Inject
    NotificationsPresenter mNotificationsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ButterKnife.bind(this);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.contentBox);
        NotificationsFragment notificationsFragment = (NotificationsFragment) fragment;

        if (notificationsFragment == null) {
            notificationsFragment = NotificationsFragment.newInstance();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(R.id.contentBox, notificationsFragment);
            transaction.commit();
        }

        DaggerNotificationsComponent.builder()
                .basicComponent(((HomelandApplication) getApplicationContext()).getBasicComponent())
                .notificationsModule(new NotificationsModule(notificationsFragment)).build()
                .inject(this);
    }

    @OnClick(R.id.btnBack)
    public void goBack() {
        finish();
    }

    @OnClick(R.id.btnClearAll)
    public void clearAll() {
        AlertDialogUtil.buildDialog(this, this).show();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

    @Override
    public void OnConfirmClick() {
        mNotificationsPresenter.clearAll();
        setResult(Activity.RESULT_OK);
    }
}
