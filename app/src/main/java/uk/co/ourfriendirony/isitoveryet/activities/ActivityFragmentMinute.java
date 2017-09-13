package uk.co.ourfriendirony.isitoveryet.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

import uk.co.ourfriendirony.isitoveryet.R;
import uk.co.ourfriendirony.isitoveryet.animations.CircleAnimation;
import uk.co.ourfriendirony.isitoveryet.shapes.Circle;

import static uk.co.ourfriendirony.isitoveryet.general.TimeHandler.MILLIS_MINUTE;
import static uk.co.ourfriendirony.isitoveryet.general.TimeHandler.getMillisThisMinute;
import static uk.co.ourfriendirony.isitoveryet.general.TimeHandler.getNow;

public class ActivityFragmentMinute extends Fragment {

    public static final int DEGREES_MAX = 360;
    public static final int DRAW_TIME = 3000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_pager_fragment_circle, container, false);
        Circle circlePrimary = (Circle) rootView.findViewById(R.id.circle_primary);
        Circle circleSecondary = (Circle) rootView.findViewById(R.id.circle_secondary);
        double percent = getElapsedTimeAsPercent();

        CircleAnimation animation = new CircleAnimation(circlePrimary, circleSecondary, getDegreesFromPercent(percent));
        animation.setDuration(DRAW_TIME);
        circlePrimary.startAnimation(animation);
        circleSecondary.startAnimation(animation);

        TextView textPercentage = (TextView) rootView.findViewById(R.id.text_percent);
        textPercentage.setText(new DecimalFormat("#.00").format(percent) + "%");

        TextView textSub = (TextView) rootView.findViewById(R.id.text_general);
        textSub.setText("Minute");
        return rootView;
    }

    private double getElapsedTimeAsPercent() {
        long passed = getNow() - getMillisThisMinute();
        return ((double) passed / MILLIS_MINUTE) * 100;
    }

    private int getDegreesFromPercent(double percent) {
        return (int) (((double) DEGREES_MAX / 100) * Math.round(percent));
    }

}
