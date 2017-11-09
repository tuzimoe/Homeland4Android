package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.di.module.LoginModule;
import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.login.LoginActivity;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/06
 * desc   :
 */
@ActivityScope
@Component(modules = LoginModule.class, dependencies = BasicComponent.class)
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
