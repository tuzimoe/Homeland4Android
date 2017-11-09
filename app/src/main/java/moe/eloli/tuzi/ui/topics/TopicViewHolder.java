package moe.eloli.tuzi.ui.topics;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import moe.eloli.tuzi.R;
import moe.eloli.tuzi.data.network.model.adjusted.TopicListItem;
import moe.eloli.tuzi.ui.topic_detail.TopicDetailActivity;
import moe.eloli.tuzi.util.FastClickUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;

import static moe.eloli.tuzi.ui.topic_detail.TopicDetailActivity.EXTRA_TOPIC_ID;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/05
 * desc   :
 */
public class TopicViewHolder extends FlexibleViewHolder {

    public @BindView(R.id.tvNodeName) TextView tvNodeName;
    public @BindView(R.id.tvTopicTitle) TextView tvTopicTitle;
    public @BindView(R.id.tvUserName) TextView tvUserName;
    public @BindView(R.id.tvCreatedDateTime) TextView tvCreatedDateTime;
    public @BindView(R.id.tvHitCount) TextView tvHitCount;
    public @BindView(R.id.tvReplyCount) TextView tvReplyCount;
    public @BindView(R.id.ivUserImage) ImageView ivUserImage;

    public TopicViewHolder(View view, FlexibleAdapter adapter) {
        super(view, adapter);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (!FastClickUtil.isFastClick()) {
            TopicListItem topic = (TopicListItem) mAdapter.getItem(getAdapterPosition());
            Intent intent = new Intent(view.getContext(), TopicDetailActivity.class);
            intent.putExtra(EXTRA_TOPIC_ID, topic.mTopicItem.getId());
            view.getContext().startActivity(intent);
        }
    }

}