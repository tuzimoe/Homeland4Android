package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.di.module.NotificationsModule;
import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.notifications.NotificationsActivity;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/6/13
 * desc   :
 */
@ActivityScope
@Component(modules = NotificationsModule.class, dependencies = BasicComponent.class)
public interface NotificationsComponent {

    void inject(NotificationsActivity notificationsActivity);

}
