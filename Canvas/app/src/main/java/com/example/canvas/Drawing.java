package com.example.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;

import androidx.annotation.Nullable;

import android.util.AttributeSet;
import android.view.View;

public class Drawing extends View {
    private Paint brush;
    private Paint redBrush;
    private LinearGradient linearGradient;
    private RadialGradient radialGradient;
    private SweepGradient sweepGradient;
    private Bitmap bitmap;

    public Drawing(Context context) {
        super(context);
        init();
    }

    public void init() {


//        bitmap = (Bitmap) BitmapFactory.decodeResource(getResources(), R.drawable.img);
        radialGradient = new RadialGradient(0, 0, 20, Color.BLUE, Color.RED, Shader.TileMode.REPEAT);
//        linearGradient = new LinearGradient(0, 0, 200, 200, Color.RED, Color.BLACK, Shader.TileMode.MIRROR);

//        brush = new Paint(Paint.ANTI_ALIAS_FLAG);
//        brush.setColor(Color.RED);
//        brush.setShader(radialGradient);


        redBrush = new Paint(Paint.ANTI_ALIAS_FLAG);
        redBrush.setColor(Color.RED);
        redBrush.setStrokeWidth(15f);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(getMeasuredWidth() / 2f, getMeasuredHeight() / 2f, 308f, redBrush);
        canvas.drawLine(0, 0, getMeasuredWidth(), getMeasuredHeight(), redBrush);
        canvas.drawLine(getMeasuredWidth(), 0, 0, getMeasuredHeight(), redBrush);
//        canvas.drawBitmap(bitmap, (getMeasuredWidth() / 2f - bitmap.getWidth() / 2f), (getMeasuredHeight() / 2f - bitmap.getHeight() / 2f), null);

        canvas.save();
        super.onDraw(canvas);
    }
}