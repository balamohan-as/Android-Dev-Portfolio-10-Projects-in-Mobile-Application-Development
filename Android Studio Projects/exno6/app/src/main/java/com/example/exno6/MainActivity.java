package com.example.exno6;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.button);
        bt2 = findViewById(R.id.button2);
        img = findViewById(R.id.imageView);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load the first image
                final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.images1); // Replace with your JPEG image name
                img.setImageBitmap(bitmap);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Load the second image
                final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.images2); // Replace with your JPEG image name
                img.setImageBitmap(bitmap);
            }
        });
    }
}
