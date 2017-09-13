package uk.co.ourfriendirony.isitoveryet.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import uk.co.ourfriendirony.isitoveryet.activities.ActivityFragmentDay;
import uk.co.ourfriendirony.isitoveryet.activities.ActivityFragmentHour;
import uk.co.ourfriendirony.isitoveryet.activities.ActivityFragmentMinute;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_PAGES = 3;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ActivityFragmentDay();
            case 1:
                return new ActivityFragmentHour();
            case 2:
                return new ActivityFragmentMinute();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Day";
            case 1:
                return "Hour";
            case 2:
                return "Minute";
        }
        return null;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}
