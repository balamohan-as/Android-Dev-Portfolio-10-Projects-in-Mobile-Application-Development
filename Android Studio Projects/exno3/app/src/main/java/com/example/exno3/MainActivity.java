package com.example.exno3;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencing the ImageView
        ImageView i = findViewById(R.id.imageView);

        // Wait until the ImageView has been laid out to get its dimensions
        i.post(new Runnable() {
            @Override
            public void run() {
                // Get the width and height of the ImageView
                int width = i.getWidth();
                int height = i.getHeight();

                // Creating a Bitmap with the dimensions of the ImageView
                Bitmap bg = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

                // Setting the Bitmap as background for the ImageView
                i.setBackground(new BitmapDrawable(getResources(), bg));

                // Creating the Canvas Object
                Canvas canvas = new Canvas(bg);

                // Creating the Paint Object for text
                Paint textPaint = new Paint();
                textPaint.setColor(Color.BLACK);
                textPaint.setTextSize(50);

                // Creating the Paint Object for shapes
                Paint shapePaint = new Paint();

                // To draw a Rectangle in Blue
                canvas.drawText("Rectangle", width * 0.6f, height * 0.1f, textPaint);
                shapePaint.setColor(Color.BLUE);
                canvas.drawRect(width * 0.55f, height * 0.15f, width * 0.9f, height * 0.55f, shapePaint);

                // To draw a Circle in Red
                canvas.drawText("Circle", width * 0.15f, height * 0.1f, textPaint);
                shapePaint.setColor(Color.RED);
                canvas.drawCircle(width * 0.3f, height * 0.35f, width * 0.2f, shapePaint);

                // To draw a Square in Green
                canvas.drawText("Square", width * 0.15f, height * 0.65f, textPaint);
                shapePaint.setColor(Color.GREEN);
                canvas.drawRect(width * 0.1f, height * 0.7f, width * 0.4f, height * 0.85f, shapePaint);

                // To draw a Line in Yellow
                canvas.drawText("Line", width * 0.6f, height * 0.65f, textPaint);
                shapePaint.setColor(Color.BLACK);
                shapePaint.setStrokeWidth(10);
                canvas.drawLine(width * 0.7f, height * 0.7f, width * 0.7f, height * 0.95f, shapePaint);
            }
        });
    }
}
