package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.di.module.TopicsModule;
import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.topics.TopicsActivity;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/04
 * desc   :
 */
@ActivityScope
@Component(modules = TopicsModule.class, dependencies = BasicComponent.class)
public interface TopicsComponent {

    void inject(TopicsActivity topicsActivity);

}
