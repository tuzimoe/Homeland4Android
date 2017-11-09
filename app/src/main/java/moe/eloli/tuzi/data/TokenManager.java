package moe.eloli.tuzi.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * author : Macrow
 * e-mail : Macrow_wh@163.com
 * time   : 2017/06/06
 * desc   :
 */
public class TokenManager {
    public static final String PREFERENCE_NAME = "moe.eloli.tuzi";
    public static final String ACCESS_TOKEN = "7908bdcbb87ad6817825655f0932856691f98969f1b50dd113a0c73a02c13ab7";
    public static final String REFRESH_TOKEN = "refresh_token";
    private String mAccessToken;
    private String mRefreshToken;

    private Context mContext;

    public TokenManager(Context context) {
        mContext = context;
        readTokens();
    }

    public String getAccessToken() {
        return mAccessToken;
    }

    public String getRefreshToken() {
        return mRefreshToken;
    }

    public void updateTokens(String access_token, String refresh_token) {
        mAccessToken = access_token;
        mRefreshToken = refresh_token;
        SharedPreferences.Editor editor = getPreferences().edit();
        editor.putString(ACCESS_TOKEN, mAccessToken);
        editor.putString(REFRESH_TOKEN, mRefreshToken);
        editor.apply();
    }

    private void readTokens() {
        SharedPreferences sharedPreferences = getPreferences();
        mAccessToken = sharedPreferences.getString(ACCESS_TOKEN, "");
        mRefreshToken = sharedPreferences.getString(REFRESH_TOKEN, "");
    }

    public void Logout() {
        updateTokens("", "");
    }

    public boolean haveTokens() {
        if (mAccessToken.equals("") || mRefreshToken.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public Context getContext() {
        return mContext;
    }

    private SharedPreferences getPreferences() {
        return mContext.getApplicationContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }
}
