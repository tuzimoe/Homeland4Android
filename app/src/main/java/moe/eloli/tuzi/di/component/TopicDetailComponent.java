package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.di.module.TopicDetailModule;
import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.topic_detail.TopicDetailActivity;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/05
 * desc   :
 */
@ActivityScope
@Component(modules = TopicDetailModule.class, dependencies = BasicComponent.class)
public interface TopicDetailComponent {

    void inject(TopicDetailActivity topicDetailActivity);

}
