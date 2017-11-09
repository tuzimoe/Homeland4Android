package moe.eloli.tuzi.di.module;

import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.profile.ProfileContract;

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
public class ProfileModule {

    private ProfileContract.View mView;

    public ProfileModule(ProfileContract.View view) {
        mView = view;
    }

    @ActivityScope
    @Provides
    ProfileContract.View provideUserProfileView() {
        return mView;
    }

    @ActivityScope
    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
