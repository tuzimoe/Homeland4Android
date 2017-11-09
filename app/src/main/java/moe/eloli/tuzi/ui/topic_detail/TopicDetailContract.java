package moe.eloli.tuzi.ui.topic_detail;

import moe.eloli.tuzi.data.network.model.adjusted.ReplyListItem;
import moe.eloli.tuzi.data.network.model.adjusted.TopicAndReplyListItem;
import moe.eloli.tuzi.ui.base.BasePresenter;
import moe.eloli.tuzi.ui.base.BaseView;

import java.util.List;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/05
 * desc   :
 */
public interface TopicDetailContract {

    interface View extends BaseView<Presenter> {

        void loadTopicAndReplyList(TopicAndReplyListItem topicAndReplyListItem);

        void loadReplyList(List<ReplyListItem> replyListItems);

        void initFavoriteAndFollowingButtonStatus(boolean isFavorite, boolean isLike, boolean isFollowing);

        void updateLikeCount(int count);

    }

    interface Presenter extends BasePresenter {

        void loadTopicAndReplyList();

        void loadReplyList();

        boolean isTopicClosed();

    }
}
