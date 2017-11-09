package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.di.module.UserTopicListModule;
import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.user_topic_list.UserTopicListActivity;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/06
 * desc   :
 */
@ActivityScope
@Component(modules = UserTopicListModule.class, dependencies = BasicComponent.class)
public interface UserTopicListComponent {

    void inject(UserTopicListActivity userTopicListActivity);

}
