package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    // Defining the Views
    EditText e1, e2;
    Button bt;
    Spinner s;

    // Data for populating in Spinner
    String[] dept_array = {"CSE", "ECE", "IT", "Mech", "Civil"};
    String name, reg, dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referring the Views
        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        bt = findViewById(R.id.button);
        s = findViewById(R.id.spinner);

        // Creating Adapter for Spinner for adapting the data from array to Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, dept_array);
        s.setAdapter(adapter);

        // Creating Listener for Button
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting the Values from Views (EditText & Spinner)
                name = e1.getText().toString();
                reg = e2.getText().toString();
                dept = s.getSelectedItem().toString();

                // Intent For Navigating to Second Activity
                Intent i = new Intent(MainActivity.this, SecondActivity.class);

                // For Passing the Values to Second Activity
                i.putExtra("name_key", name);
                i.putExtra("reg_key", reg);
                i.putExtra("dept_key", dept);
                startActivity(i);
            }
        });
    }
}
