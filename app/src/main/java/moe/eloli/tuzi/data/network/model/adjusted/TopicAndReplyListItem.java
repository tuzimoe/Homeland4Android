package moe.eloli.tuzi.data.network.model.adjusted;

import java.util.List;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/05
 * desc   :
 */
public class TopicAndReplyListItem {

    public TopicDetailItem mTopicDetailItem;
    public List<ReplyListItem> mReplyListItem;

    public TopicAndReplyListItem(TopicDetailItem topicDetailItem, List<ReplyListItem> replyListItems) {
        mTopicDetailItem = topicDetailItem;
        mReplyListItem = replyListItems;
    }

}
