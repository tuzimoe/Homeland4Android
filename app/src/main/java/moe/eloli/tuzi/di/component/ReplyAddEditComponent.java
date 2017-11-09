package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.di.module.ReplyAddEditModule;
import moe.eloli.tuzi.di.notation.ActivityScope;
import moe.eloli.tuzi.ui.reply_add_edit.ReplyAddEditActivity;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/6/10
 * desc   :
 */
@ActivityScope
@Component(modules = ReplyAddEditModule.class, dependencies = BasicComponent.class)
public interface ReplyAddEditComponent {

    void inject(ReplyAddEditActivity replyAddEditActivity);

}
