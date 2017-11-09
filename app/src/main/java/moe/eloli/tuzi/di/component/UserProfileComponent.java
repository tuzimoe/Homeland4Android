package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.di.module.UserProfileModule;
import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.user_profile.UserProfileActivity;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/06
 * desc   :
 */
@ActivityScope
@Component(modules = UserProfileModule.class, dependencies = BasicComponent.class)
public interface UserProfileComponent {

    void inject(UserProfileActivity userProfileActivity);

}
