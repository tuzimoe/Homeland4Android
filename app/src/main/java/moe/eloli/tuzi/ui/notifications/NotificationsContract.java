package moe.eloli.tuzi.ui.notifications;

import moe.eloli.tuzi.data.network.model.adjusted.NotificationListItem;
import moe.eloli.tuzi.ui.base.BasePresenter;
import moe.eloli.tuzi.ui.base.BaseView;

import java.util.List;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/6/13
 * desc   :
 */
public interface NotificationsContract {

    interface View extends BaseView<Presenter> {

        void loadNotificationList(List<NotificationListItem> notifications, boolean reload);

        void clearAllNotifications();

    }

    interface Presenter extends BasePresenter {

        void loadNotificationList(boolean reload);

    }
}
