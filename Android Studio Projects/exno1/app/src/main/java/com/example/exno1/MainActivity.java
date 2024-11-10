package com.example.exno1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int ch = 1;
    float font = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView titleTextView = findViewById(R.id.titleTextView);
        EditText inputEditText = findViewById(R.id.inputEditText);
        Button submitButton = findViewById(R.id.submitButton);
        Button changeColorButton = findViewById(R.id.changeColorButton);


        submitButton.setOnClickListener(v -> {
            titleTextView.setTextSize(font);
            font = font + 5;
            if (font == 50) font = 30;
        });

        changeColorButton.setOnClickListener(v -> {
            switch (ch) {
                case 1:
                    titleTextView.setTextColor(Color.RED);
                    break;
                case 2:
                    titleTextView.setTextColor(Color.GREEN);
                    break;
                case 3:
                    titleTextView.setTextColor(Color.BLUE);
                    break;
                case 4:
                    titleTextView.setTextColor(Color.CYAN);
                    break;
                case 5:
                    titleTextView.setTextColor(Color.YELLOW);
                    break;
                case 6:
                    titleTextView.setTextColor(Color.MAGENTA);
                    break;
            }
            ch++;
            if (ch == 7) ch = 1;
        });
    }
}