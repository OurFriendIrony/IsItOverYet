package uk.co.ourfriendirony.isitoveryet.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Circle extends View {

    private static final int STROKE_WIDTH = 70;
    private static final int POS_DIFF = 100;
    private static final int START_ANGLE_POINT = 269;
    private final Paint paint;

    private float angle;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);

        angle = 0;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(STROKE_WIDTH);
        paint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rect = new RectF(getLeft() + POS_DIFF,
                getTop() + POS_DIFF,
                getRight() - POS_DIFF,
                getBottom() - POS_DIFF);
        canvas.drawArc(rect, START_ANGLE_POINT, angle, false, paint);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}

