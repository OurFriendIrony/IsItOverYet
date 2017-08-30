package uk.co.ourfriendirony.isitoveryet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Calendar;

import uk.co.ourfriendirony.isitoveryet.animations.CircleAngleAnimation;
import uk.co.ourfriendirony.isitoveryet.shapes.Circle;
import uk.co.ourfriendirony.isitoveryet.shapes.Coords;

import static uk.co.ourfriendirony.isitoveryet.R.string.PERCENT_010;
import static uk.co.ourfriendirony.isitoveryet.R.string.PERCENT_020;
import static uk.co.ourfriendirony.isitoveryet.R.string.PERCENT_030;
import static uk.co.ourfriendirony.isitoveryet.R.string.PERCENT_040;
import static uk.co.ourfriendirony.isitoveryet.R.string.PERCENT_050;
import static uk.co.ourfriendirony.isitoveryet.R.string.PERCENT_060;
import static uk.co.ourfriendirony.isitoveryet.R.string.PERCENT_070;
import static uk.co.ourfriendirony.isitoveryet.R.string.PERCENT_080;
import static uk.co.ourfriendirony.isitoveryet.R.string.PERCENT_090;
import static uk.co.ourfriendirony.isitoveryet.R.string.PERCENT_100;

public class ActivityMain extends AppCompatActivity {

    public static final int DEGREES_MAX = 360;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Circle circle = (Circle) findViewById(R.id.circle);
        Coords coords = new Coords()
                .setLeft(250).setRight(1250).setTop(50).setBottom(1050);
        circle.setCoords(coords);

        double percent = getElapsedTimeAsPercent();

        CircleAngleAnimation animation = new CircleAngleAnimation(circle, getDegreesFromPercent(percent));
        animation.setDuration(5000);
        circle.startAnimation(animation);

        TextView textPercentage = (TextView) findViewById(R.id.text_percent);
        textPercentage.setText(new DecimalFormat("#.00").format(percent) + "%");

        TextView textSub = (TextView) findViewById(R.id.text_general);
        textSub.setText(getPercentageString(percent));
    }

    private double getElapsedTimeAsPercent() {
        final long totalMillis = 86400000;

        Calendar c = Calendar.getInstance();
        long now = c.getTimeInMillis();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long passed = now - c.getTimeInMillis();

        return ((double) passed / totalMillis) * 100;
    }

    private int getDegreesFromPercent(double percent) {
        int degrees = (int) ((DEGREES_MAX / 100) * Math.round(percent));
        if (degrees < 0)
            return 0;
        else if (degrees > DEGREES_MAX)
            return DEGREES_MAX;
        return degrees;
    }

    private String getPercentageString(double percent) {
        if (percent <= 10)
            return getStringResource(PERCENT_010);
        else if (percent <= 20)
            return getStringResource(PERCENT_020);
        else if (percent <= 30)
            return getStringResource(PERCENT_030);
        else if (percent <= 40)
            return getStringResource(PERCENT_040);
        else if (percent <= 50)
            return getStringResource(PERCENT_050);
        else if (percent <= 60)
            return getStringResource(PERCENT_060);
        else if (percent <= 70)
            return getStringResource(PERCENT_070);
        else if (percent <= 80)
            return getStringResource(PERCENT_080);
        else if (percent <= 90)
            return getStringResource(PERCENT_090);
        else if (percent <= 100)
            return getStringResource(PERCENT_100);
        return "??";
    }

    @NonNull
    private String getStringResource(int x) {
        return getApplication().getApplicationContext().getString(x);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
