package fatty.arcpic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Fatty on 2017-02-12.
 */

public class showArcPic extends View {

    private int length = 0,mSweepAngle = 240;
    private float mCircleXY,mRadius;
    private RectF mArcRectF;
    private Paint mCirclePaint,mCirclePaint2,mArcPaint,mTextPaint;
    private String mShowText = "弧線比例圖 75%";

    public showArcPic(Context context, AttributeSet attrs){
        super(context,attrs);

        int color = 0xffffffff;

        mCirclePaint = new Paint();
        mCirclePaint.setColor(color);
        mCirclePaint.setStyle(Paint.Style.FILL);

        mArcPaint = new Paint();
        mArcPaint.setColor(color);

        mCirclePaint2 = new Paint();
        color = 0xffE1B1BB;
        mCirclePaint2.setColor(color);
        mCirclePaint2.setStyle(Paint.Style.FILL);

        mTextPaint = new Paint();
        color = 0xff5E2430;
        mTextPaint.setColor(color);
        mTextPaint.setTextSize(50);
        mTextPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw (Canvas canvas) {

        super.onDraw(canvas);

        length = getMeasuredWidth();

        mCircleXY = length/2;
        mRadius = (float)(length*0.5/2);

        mArcRectF = new RectF(
                (float)(length*0.1),
                (float)(length*0.1),
                (float)(length*0.9),
                (float)(length*0.9));

        canvas.drawArc(mArcRectF ,270 ,mSweepAngle ,true ,mArcPaint);
        canvas.drawCircle(mCircleXY ,mCircleXY ,mRadius + 50 ,mCirclePaint2);
        canvas.drawCircle(mCircleXY ,mCircleXY ,mRadius - 50 ,mCirclePaint);
        canvas.drawText(mShowText ,0 ,mShowText.length() ,mCircleXY *2/3 ,mCircleXY +(mShowText.length()/4) ,mTextPaint);
    }
}
