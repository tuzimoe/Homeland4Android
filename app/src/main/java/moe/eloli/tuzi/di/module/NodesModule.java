package moe.eloli.tuzi.di.module;

import moe.eloli.tuzi.di.notation.FragmentScope;
import moe.eloli.tuzi.ui.nodes.NodesContract;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/07
 * desc   :
 */
@Module
public class NodesModule {

    private NodesContract.View mView;

    public NodesModule(NodesContract.View view) {
        mView = view;
    }

    @FragmentScope
    @Provides
    NodesContract.View provideNodesContractView() {
        return mView;
    }

    @FragmentScope
    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
