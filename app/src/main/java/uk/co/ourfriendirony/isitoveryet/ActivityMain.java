package uk.co.ourfriendirony.isitoveryet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import uk.co.ourfriendirony.isitoveryet.animations.CircleAngleAnimation;
import uk.co.ourfriendirony.isitoveryet.shapes.Circle;

import static uk.co.ourfriendirony.isitoveryet.R.string.*;

public class ActivityMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Circle circle = (Circle) findViewById(R.id.circle);

        CircleAngleAnimation animation = new CircleAngleAnimation(circle, 300);
        animation.setDuration(1000);
        circle.startAnimation(animation);
        TextView text = (TextView) findViewById(R.id.main_text);

        text.setText(getPercentageString(30));


    }

    private String getPercentageString(int percentage) {
        if (percentage <= 10)
            return getStringResource(PERCENT_010);
        else if (percentage <= 20)
            return getStringResource(PERCENT_020);
        else if (percentage <= 30)
            return getStringResource(PERCENT_030);
        else if (percentage <= 40)
            return getStringResource(PERCENT_040);
        else if (percentage <= 50)
            return getStringResource(PERCENT_050);
        else if (percentage <= 60)
            return getStringResource(PERCENT_060);
        else if (percentage <= 70)
            return getStringResource(PERCENT_070);
        else if (percentage <= 80)
            return getStringResource(PERCENT_080);
        else if (percentage <= 90)
            return getStringResource(PERCENT_090);
        else if (percentage <= 100)
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
