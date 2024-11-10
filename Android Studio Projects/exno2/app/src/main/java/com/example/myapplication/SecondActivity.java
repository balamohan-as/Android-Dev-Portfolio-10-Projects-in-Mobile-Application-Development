package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView t1, t2, t3;
    String name, reg, dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Referring the Views
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);

        // Getting the Intent
        Intent i = getIntent();

        // Getting the Values from First Activity using the Intent
        name = i.getStringExtra("name_key");
        reg = i.getStringExtra("reg_key");
        dept = i.getStringExtra("dept_key");

        // Setting the Values to TextViews
        t1.setText(name);
        t2.setText(reg);
        t3.setText(dept);
    }
}
