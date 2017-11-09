package moe.eloli.tuzi.di.module;

import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.notifications.NotificationsContract;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/6/13
 * desc   :
 */
@Module
public class NotificationsModule {

    private NotificationsContract.View mView;

    public NotificationsModule(NotificationsContract.View view) {
        mView = view;
    }

    @ActivityScope
    @Provides
    NotificationsContract.View provideNotificationsContractView() {
        return mView;
    }

    @ActivityScope
    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
