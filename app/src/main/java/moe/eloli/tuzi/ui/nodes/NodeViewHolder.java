package moe.eloli.tuzi.ui.nodes;

import android.view.View;
import android.widget.TextView;

import com.mikepenz.iconics.view.IconicsImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/07
 * desc   :
 */
public class NodeViewHolder extends FlexibleViewHolder {

    public @BindView(moe.eloli.tuzi.R.id.tvNodeName)
    TextView tvNodeName;
    public @BindView(moe.eloli.tuzi.R.id.tvNodeDescription)
    TextView tvNodeDescription;
    public @BindView(moe.eloli.tuzi.R.id.iiIcon)
    IconicsImageView iiIcon;

    public NodeViewHolder(View view, FlexibleAdapter adapter) {
        super(view, adapter);
        ButterKnife.bind(this, view);
    }

}