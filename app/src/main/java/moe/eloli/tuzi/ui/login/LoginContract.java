package moe.eloli.tuzi.ui.login;

import android.content.Context;

import moe.eloli.tuzi.ui.base.BasePresenter;
import moe.eloli.tuzi.ui.base.BaseView;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/06
 * desc   :
 */
public class LoginContract {

    public interface View extends BaseView<Presenter> {

        void finishActivity();

        Context getContext();

    }

    public interface Presenter extends BasePresenter {

        void LoginByAuthCode(String cdoe);

    }

}
