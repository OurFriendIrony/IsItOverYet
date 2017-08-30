package uk.co.ourfriendirony.isitoveryet.db;

import android.content.Context;
import android.content.SharedPreferences;

import uk.co.ourfriendirony.isitoveryet.R;

import static android.content.Context.MODE_PRIVATE;

public class PropertyHelper {
    private static String APP_NAME = String.valueOf(R.string.app_name);

    private static String PROPERTY_NAME = "prop_name";
    private static String PROPERTY_DEFAULT = "DefaultProperty";

    public static String getProperty(Context context) {
        SharedPreferences settings = context.getSharedPreferences(APP_NAME, MODE_PRIVATE);
        return settings.getString(PROPERTY_NAME, PROPERTY_DEFAULT);
    }

    public static void setProperty(Context context, String newValue) {
        SharedPreferences settings = context.getSharedPreferences(APP_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(PROPERTY_NAME, newValue);
        editor.apply();
    }
}
