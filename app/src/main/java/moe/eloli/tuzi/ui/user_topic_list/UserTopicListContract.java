package moe.eloli.tuzi.ui.user_topic_list;

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
public interface UserTopicListContract {

    interface View extends BaseView<Presenter> {

        void loadTopicList(List<TopicListItem> topics, boolean reload);

    }

    interface Presenter extends BasePresenter {

        void loadTopicList(boolean reload);

    }
}
