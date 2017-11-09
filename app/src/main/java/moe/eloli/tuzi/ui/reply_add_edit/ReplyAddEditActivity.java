package moe.eloli.tuzi.ui.reply_add_edit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import moe.eloli.tuzi.HomelandApplication;
import moe.eloli.tuzi.R;
import moe.eloli.tuzi.di.component.DaggerReplyAddEditComponent;
import moe.eloli.tuzi.di.module.ReplyAddEditModule;
import moe.eloli.tuzi.ui.base.AlertDialogCaller;
import moe.eloli.tuzi.ui.base.BaseActivity;
import moe.eloli.tuzi.util.AlertDialogUtil;
import moe.eloli.tuzi.util.AppConstant;
import moe.eloli.tuzi.util.FastClickUtil;
import moe.eloli.tuzi.util.ImageGetterUtil;

import static moe.eloli.tuzi.ui.topic_detail.TopicDetailActivity.EXTRA_TOPIC_ID;
import static moe.eloli.tuzi.util.AppConstant.CAMERA_REQUEST_CODE;

public class ReplyAddEditActivity extends BaseActivity implements AlertDialogCaller {

    public static final String EXTRA_REPLY_ID = "EXTRA_REPLY_ID";

    private int mTopicId;
    private int mReplyId;
    private String mCameraPath;

    @Inject
    ReplyAddEditPresenter mReplyAddEditPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_add_edit);
        ButterKnife.bind(this);
        mTopicId = getIntent().getIntExtra(EXTRA_TOPIC_ID, 0);
        mReplyId = getIntent().getIntExtra(EXTRA_REPLY_ID, 0);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.contentBox);
        ReplyAddEditFragment replyAddEditFragment = (ReplyAddEditFragment) fragment;
        if (replyAddEditFragment == null) {
            replyAddEditFragment = ReplyAddEditFragment.newInstance(mTopicId, mReplyId);
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(R.id.contentBox, replyAddEditFragment);
            transaction.commit();
        }

        DaggerReplyAddEditComponent.builder()
                .basicComponent(((HomelandApplication) getApplication()).getBasicComponent())
                .replyAddEditModule(new ReplyAddEditModule(replyAddEditFragment, mTopicId, mReplyId)).build()
                .inject(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == AppConstant.ALBUM_REQUEST_CODE) {
                Uri uri = data.getData();
                if (uri != null) {
                    String absolutePath= ImageGetterUtil.getAbsolutePath(this, uri);
                    mReplyAddEditPresenter.uploadPhoto(absolutePath);
                }
            } else if (requestCode == CAMERA_REQUEST_CODE) {
                if (mCameraPath != null) {
                    mReplyAddEditPresenter.uploadPhoto(mCameraPath);
                }
            }
        }
    }

    @OnClick(R.id.btnBack)
    public void goBack() {
        if (!FastClickUtil.isFastClick()) {
            if (mReplyAddEditPresenter.isReplyDirty()) {
                AlertDialogUtil.buildDialog(this, this).show();
            } else {
                finish();
            }

        }
    }

    @OnClick(R.id.btnCreateOrUpdate)
    public void createOrUpdateReply() {
        if (!FastClickUtil.isFastClick()) {
            if (mTopicId != 0) {
                mReplyAddEditPresenter.createReply();
            } else {
                mReplyAddEditPresenter.updateReply();
            }
        }
    }

    @OnClick(R.id.btnCamera)
    public void loadImageFromCamera() {
        mCameraPath = ImageGetterUtil.openCamera(this);
    }

    @OnClick(R.id.btnGallery)
    public void loadImageFromGallery() {
        ImageGetterUtil.openGallery(this);
    }

    @Override
    public void OnConfirmClick() {
        finish();
    }
}
