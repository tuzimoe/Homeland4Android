package moe.eloli.tuzi.data;

import moe.eloli.tuzi.data.network.OAuthService;
import moe.eloli.tuzi.data.network.model.raw.RawToken;
import moe.eloli.tuzi.util.AppConstant;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/05
 * desc   :
 */
public class OAuthDataManager {

    private OAuthService mOAuthService;

    @Inject
    public OAuthDataManager(OAuthService oAuthService) {
        mOAuthService = oAuthService;
    }

    public Observable<RawToken> LoginByAuthCode(String code) {
        return mOAuthService.getTokenByAuthCode(
                AppConstant.CLIENT_ID,
                AppConstant.CLIENT_SECRET,
                code,
                AppConstant.GRANT_TYPE_AUTH_CODE,
                AppConstant.CALLBACK_URI);
    }

}
