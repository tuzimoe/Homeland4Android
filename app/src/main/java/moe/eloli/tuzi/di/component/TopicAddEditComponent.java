package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.di.module.TopicAddEditModule;
import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.topic_add_edit.TopicAddEditActivity;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/6/9
 * desc   :
 */
@ActivityScope
@Component(modules = TopicAddEditModule.class, dependencies = BasicComponent.class)
public interface TopicAddEditComponent {

    void inject(TopicAddEditActivity topicAddEditActivity);

}
