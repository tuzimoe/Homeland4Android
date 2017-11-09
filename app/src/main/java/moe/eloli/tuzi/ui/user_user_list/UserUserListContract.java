package moe.eloli.tuzi.ui.user_user_list;

import moe.eloli.tuzi.data.network.model.adjusted.UserListItem;
import moe.eloli.tuzi.ui.base.BasePresenter;
import moe.eloli.tuzi.ui.base.BaseView;

import java.util.List;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/04
 * desc   :
 */
public interface UserUserListContract {

    interface View extends BaseView<Presenter> {

        void loadUserList(List<UserListItem> users, boolean reload);

    }

    interface Presenter extends BasePresenter {

        void loadUserList(boolean reload);

    }
}
