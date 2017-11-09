package moe.eloli.tuzi.ui.topics;

import moe.eloli.tuzi.data.network.model.adjusted.TopicListItem;
import moe.eloli.tuzi.ui.base.BasePresenter;
import moe.eloli.tuzi.ui.base.BaseView;

import java.util.List;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/04
 * desc   :
 */
public interface TopicsContract {

    interface View extends BaseView<Presenter> {

        void loadTopicList(List<TopicListItem> topics, boolean reload);

        void showPullLoading();

        void updateUnreadNotification(int count);

    }

    interface Presenter extends BasePresenter {

        void loadTopicList(boolean reload);

    }
}
