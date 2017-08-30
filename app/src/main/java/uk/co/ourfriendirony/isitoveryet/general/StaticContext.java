package uk.co.ourfriendirony.isitoveryet.general;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

public class StaticContext extends Application {
    protected static Context context;

    public static Context getStaticContext() {
        return context;
    }

    public static Resources getStaticResources() {
        return context.getResources();
    }

    public static String getProjectString(int ref) {
        return getStaticResources().getString(ref);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
