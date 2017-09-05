package uk.co.ourfriendirony.isitoveryet.animations;

import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import uk.co.ourfriendirony.isitoveryet.shapes.Circle;

public class CircleAnimation extends Animation {

    private final Circle circlePrimary;
    private final Circle circleSecondary;

    private float oldAngle;
    private float newAngle;

    public CircleAnimation(Circle circlePrimary, Circle circleSecondary, int newAngle) {
        this.oldAngle = circlePrimary.getAngle();
        this.newAngle = newAngle;
        this.circlePrimary = circlePrimary;
        this.circleSecondary = circleSecondary;

        this.circleSecondary.setColour(Color.BLACK);
        this.circlePrimary.setColour(Color.GREEN);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);

        circlePrimary.setAngle(angle);
        circlePrimary.requestLayout();

        circleSecondary.setAngle(360);
        circleSecondary.requestLayout();
    }
}
