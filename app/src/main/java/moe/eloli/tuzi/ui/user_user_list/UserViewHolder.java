package moe.eloli.tuzi.ui.user_user_list;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import moe.eloli.tuzi.R;
import moe.eloli.tuzi.data.network.model.adjusted.UserListItem;
import moe.eloli.tuzi.ui.user_profile.UserProfileActivity;
import moe.eloli.tuzi.util.FastClickUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/14
 * desc   :
 */
public class UserViewHolder extends FlexibleViewHolder {

    public @BindView(R.id.tvLogin) TextView tvLogin;
    public @BindView(R.id.tvName) TextView tvName;
    public @BindView(R.id.ivImage) ImageView ivImage;

    public UserViewHolder(View view, FlexibleAdapter adapter) {
        super(view, adapter);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        if (!FastClickUtil.isFastClick()) {
            UserListItem user = (UserListItem) mAdapter.getItem(getAdapterPosition());
            Intent intent = new Intent(view.getContext(), UserProfileActivity.class);
            intent.putExtra(UserProfileActivity.EXTRA_USER_LOGIN_NAME, user.getLogin());
            view.getContext().startActivity(intent);
        }
    }

}