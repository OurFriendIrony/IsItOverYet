package uk.co.ourfriendirony.isitoveryet.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import uk.co.ourfriendirony.isitoveryet.R;
import uk.co.ourfriendirony.isitoveryet.pager.PagerAdapter;

import static uk.co.ourfriendirony.isitoveryet.general.IntentGenerator.getContactEmailIntent;

public class ActivityPager extends AppCompatActivity {

    private ViewPager mPager;
    private android.support.v4.view.PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
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
                Toast.makeText(this, R.string.NYI, Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
