package moe.eloli.tuzi.di.component;

import moe.eloli.tuzi.data.AuthorizedDataManager;
import moe.eloli.tuzi.data.NoAuthorizedDataManager;
import moe.eloli.tuzi.data.OAuthDataManager;
import moe.eloli.tuzi.data.TokenManager;
import moe.eloli.tuzi.di.module.BasicModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/04
 * desc   :
 */
@Singleton
@Component(modules = BasicModule.class)
public interface BasicComponent {

    TokenManager provideTokenManager();

    NoAuthorizedDataManager provideDataManager();

    OAuthDataManager provideOAuthDataManager();

    AuthorizedDataManager provideAuthorizedDataManager();

}
