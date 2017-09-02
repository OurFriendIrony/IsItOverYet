package uk.co.ourfriendirony.isitoveryet.shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Circle extends View {

    public static final String OFI_NAMESPACE = "http://ourfriendirony.co.uk/apps";
    private static final int POS_DIFF = 100;
    private static final int START_ANGLE_POINT = 269;
    private final Paint paint;
    private RectF rect = new RectF();
    private float angle;
    private int colour;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);

        angle = 0;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getStrokeWidth(attrs));
    }

    private int getStrokeWidth(AttributeSet attrs) {
        return attrs.getAttributeIntValue(OFI_NAMESPACE, "width", 70);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rect.set(
                getLeft() + POS_DIFF,
                getTop() + POS_DIFF,
                getRight() - POS_DIFF,
                getBottom() - POS_DIFF
        );
        paint.setColor(colour);
        canvas.drawArc(rect, START_ANGLE_POINT, angle, false, paint);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }
}
