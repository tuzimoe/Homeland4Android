package moe.eloli.tuzi.ui.topic_add_edit;

import android.content.Context;

import moe.eloli.tuzi.data.network.model.adjusted.TopicDetailItem;
import moe.eloli.tuzi.ui.base.BasePresenter;
import moe.eloli.tuzi.ui.base.BaseView;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/09
 * desc   :
 */

public interface TopicAddEditContract {

    interface View extends BaseView<Presenter> {

        boolean validateTopic();

        String getTitle();

        int getNodeId();

        String getBody();

        Context getViewContext();

        void loadTopic(TopicDetailItem topicDetailItem);

        boolean isTopicDirty();

        void startListenTopicChanged();

        void uploadPhoto(String url);

    }

    interface Presenter extends BasePresenter {

        void createTopic();

        void updateTopic();

        void uploadPhoto(String path);

    }
}
