package uk.co.ourfriendirony.isitoveryet.general;

import java.util.Calendar;

public class TimeHandler {
    public static int MILLIS_DAY = 86400000;
    public static int MILLIS_HOUR = 3600000;
    public static int MILLIS_MINUTE = 60000;

    public static long getNow() {
        Calendar c = Calendar.getInstance();
        return c.getTimeInMillis();
    }

    public static long getMillisThisMinute() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }

    public static long getMillisThisHour() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }

    public static long getMillisThisDay() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }
}
