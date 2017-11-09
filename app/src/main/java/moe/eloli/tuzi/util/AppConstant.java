package moe.eloli.tuzi.util;

import android.os.Environment;

public class AppConstant {

    public static final String APP_NAME = "Eloli Andriod";
    public static final String GITHUB_LINK = "https://github.com/tuzimoe/Homeland4Android";

    public static final String BASE_URL = "https://eloli.moe/";
    public static final String API_BASE_URL = BASE_URL + "api/v3/";
    public static final String OAUTH_AUTH_URL = "https://eloli.moe/oauth/authorize";

    public static final String CLIENT_ID = "4768ed92";
    public static final String CLIENT_SECRET = "7908bdcbb87ad6817825655f0932856691f98969f1b50dd113a0c73a02c13ab7";
    public static final String CALLBACK_URI = "eloli://oauth";
    public static final String GRANT_TYPE_AUTH_CODE = "authorization_code";
    public static final String OAUTH_LOGIN_URI = OAUTH_AUTH_URL + "?client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&redirect_uri=" + CALLBACK_URI + "&response_type=authorization_code";

    public static final int PAGE_LIMIT = 20;
    public final static int ALBUM_REQUEST_CODE = 1;
    public final static int CAMERA_REQUEST_CODE = 2;
    public static String SAVED_IMAGE_DIR_PATH = Environment.getExternalStorageDirectory().getPath() + "/" + APP_NAME + "/camera/";

}
