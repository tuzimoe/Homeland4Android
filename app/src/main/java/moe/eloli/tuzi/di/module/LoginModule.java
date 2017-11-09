package moe.eloli.tuzi.di.module;

import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.login.LoginContract;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/06
 * desc   :
 */
@Module
public class LoginModule {

    private LoginContract.View mView;

    public LoginModule(LoginContract.View view) {
        mView = view;
    }

    @ActivityScope
    @Provides
    LoginContract.View provideLoginContractView() {
        return mView;
    }

    @ActivityScope
    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
