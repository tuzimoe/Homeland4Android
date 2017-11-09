package moe.eloli.tuzi.data.network.model.adjusted;

import moe.eloli.tuzi.data.network.model.raw.RawUser;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/06
 * desc   :
 */
public class User {

    public RawUser.UserBean mUser;
    public RawUser.MetaBean mStatus;

    public User(RawUser.UserBean user, RawUser.MetaBean meta) {
        mUser = user;
        mStatus = meta;
    }

}
