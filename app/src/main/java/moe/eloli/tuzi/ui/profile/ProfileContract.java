package moe.eloli.tuzi.ui.profile;

import moe.eloli.tuzi.data.network.model.adjusted.User;
import moe.eloli.tuzi.ui.base.BasePresenter;
import moe.eloli.tuzi.ui.base.BaseView;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/06
 * desc   :
 */
public interface ProfileContract {

    interface View extends BaseView<Presenter> {

        void loadProfile(User user);

        void updateUnreadNotificationCount(int count);

    }

    interface Presenter extends BasePresenter {

        void loadProfile();

        void Logout();

        String getProfileLoginName();

    }
}
