package moe.eloli.tuzi.ui.user_profile;

import moe.eloli.tuzi.data.network.model.adjusted.User;
import moe.eloli.tuzi.ui.base.BasePresenter;
import moe.eloli.tuzi.ui.base.BaseView;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/06
 * desc   :
 */
public interface UserProfileContract {

    interface View extends BaseView<Presenter> {

        void loadProfile(User user);

        void loadActionView(boolean isBlocked, boolean isFollowed);

        void updateUserFollowers(String number);

    }

    interface Presenter extends BasePresenter {

        void loadProfile();

        String getUserLoginName();

        void updateBlockUserStatus();

        void updateFollowingUserStatus();

    }
}
