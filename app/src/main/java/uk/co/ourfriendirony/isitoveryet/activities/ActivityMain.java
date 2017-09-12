package uk.co.ourfriendirony.isitoveryet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Calendar;

import uk.co.ourfriendirony.isitoveryet.R;
import uk.co.ourfriendirony.isitoveryet.animations.CircleAnimation;
import uk.co.ourfriendirony.isitoveryet.shapes.Circle;

import static uk.co.ourfriendirony.isitoveryet.general.IntentGenerator.getContactEmailIntent;

public class ActivityMain extends AppCompatActivity {

    public static final int DEGREES_MAX = 360;
    public static final int DRAW_TIME = 5000;
    public static final int MILLIS_IN_A_DAY = 86400000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Circle circlePrimary = (Circle) findViewById(R.id.circle_primary);
        Circle circleSecondary = (Circle) findViewById(R.id.circle_secondary);

        double percent = getElapsedTimeAsPercent();

        CircleAnimation animation = new CircleAnimation(circlePrimary, circleSecondary, getDegreesFromPercent(percent));
        animation.setDuration(DRAW_TIME);
        circlePrimary.startAnimation(animation);
        circleSecondary.startAnimation(animation);

        TextView textPercentage = (TextView) findViewById(R.id.text_percent);
        textPercentage.setText(new DecimalFormat("#.00").format(percent) + "%");

        TextView textSub = (TextView) findViewById(R.id.text_general);
        textSub.setText(getPercentageString(percent));
    }

    private double getElapsedTimeAsPercent() {
        final long totalMillis = MILLIS_IN_A_DAY;

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
        return (int) (((double) DEGREES_MAX / 100) * Math.round(percent));
    }

    private String getPercentageString(double percent) {
        if (percent < 20)
            return getResource(R.string.PERCENT_000);
        else if (percent < 40)
            return getResource(R.string.PERCENT_020);
        else if (percent < 60)
            return getResource(R.string.PERCENT_040);
        else if (percent < 80)
            return getResource(R.string.PERCENT_060);
        else if (percent < 100)
            return getResource(R.string.PERCENT_080);
        else if (percent == 100)
            return getResource(R.string.PERCENT_100);
        return "??";
    }

    @NonNull
    private String getResource(int resourceId) {
        return getResources().getString(resourceId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, ActivitySettings.class);
                startActivity(intent);
                return true;

            case R.id.action_contact:
                startActivity(getContactEmailIntent());
                return true;

            case R.id.action_about:
                startActivity(new Intent(this, ScreenSlidePagerActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
