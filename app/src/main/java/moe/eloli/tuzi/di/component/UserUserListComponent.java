package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.di.module.UserUserListModule;
import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.user_user_list.UserUserListActivity;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/06
 * desc   :
 */
@ActivityScope
@Component(modules = UserUserListModule.class, dependencies = BasicComponent.class)
public interface UserUserListComponent {

    void inject(UserUserListActivity userUserListActivity);

}
