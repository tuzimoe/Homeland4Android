package moe.eloli.tuzi.ui.reply_add_edit;

import moe.eloli.tuzi.data.network.model.adjusted.ReplyDetailItem;
import moe.eloli.tuzi.ui.base.BasePresenter;
import moe.eloli.tuzi.ui.base.BaseView;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/6/10
 * desc   :
 */
public interface ReplyAddEditContract {

    interface View extends BaseView<Presenter> {

        boolean validateReply();

        String getBody();

        void loadReply(ReplyDetailItem replyDetailItem);

        boolean isReplyDirty();

        void startListenReplyChanged();

        void uploadPhoto(String url);

    }

    interface Presenter extends BasePresenter {

        void createReply();

        void updateReply();

        void uploadPhoto(String path);

    }
}
