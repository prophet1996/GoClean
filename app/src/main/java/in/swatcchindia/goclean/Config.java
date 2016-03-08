package in.swatcchindia.goclean;

import android.graphics.Bitmap;

/**
 * Created by PROPHET on 06-03-2016.
 */
public class Config {
    public static String[] names;
    public static String[] urls;
    public static Bitmap[] bitmaps;

    public static final String GET_URL = "http://simplifiedcoding.16mb.com/CardView/getData.php";
    public static final String TAG_IMAGE_URL = "url";
    public static final String TAG_IMAGE_NAME = "name";
    public static final String TAG_JSON_ARRAY = "result";

    public Config(int i) {
        names = new String[i];
        urls = new String[i];
        bitmaps = new Bitmap[i];
    }
}