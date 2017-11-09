package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.di.module.NodesModule;
import moe.eloli.tuzi.di.notation.FragmentScope;
import moe.eloli.tuzi.ui.nodes.NodesDialogFragment;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/07
 * desc   :
 */
@FragmentScope
@Component(modules = NodesModule.class, dependencies = BasicComponent.class)
public interface NodesComponent {

    void inject(NodesDialogFragment nodesDialogFragment);

}
