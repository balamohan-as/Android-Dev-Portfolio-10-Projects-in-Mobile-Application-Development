package com.example.exno4;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

    EditText Rollno, Name, Marks;
    Button Insert, Delete, Update, View, ViewAll;
    SQLiteDatabase db;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rollno = findViewById(R.id.Rollno);
        Name = findViewById(R.id.Name);
        Marks = findViewById(R.id.Marks);
        Insert = findViewById(R.id.Insert);
        Delete = findViewById(R.id.Delete);
        Update = findViewById(R.id.Update);
        View = findViewById(R.id.View);
        ViewAll = findViewById(R.id.ViewAll);

        Insert.setOnClickListener(this);
        Delete.setOnClickListener(this);
        Update.setOnClickListener(this);
        View.setOnClickListener(this);
        ViewAll.setOnClickListener(this);

        // Creating database and table
        db = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR, name VARCHAR, marks VARCHAR);");
    }

    @Override
    public void onClick(View view) {
        // Inserting a record to the Student table
        if (view == Insert) {
            // Checking for empty fields
            if (Rollno.getText().toString().trim().isEmpty() ||
                    Name.getText().toString().trim().isEmpty() ||
                    Marks.getText().toString().trim().isEmpty()) {
                showMessage("Error", "Please enter all values");
                return;
            }
            db.execSQL("INSERT INTO student VALUES(?, ?, ?);",
                    new Object[]{Rollno.getText().toString(), Name.getText().toString(), Marks.getText().toString()});
            showMessage("Success", "Record added");
            clearText();
        }
        // Deleting a record from the Student table
        else if (view == Delete) {
            // Checking for empty roll number
            if (Rollno.getText().toString().trim().isEmpty()) {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno = ?", new String[]{Rollno.getText().toString()});
            if (c.moveToFirst()) {
                db.execSQL("DELETE FROM student WHERE rollno = ?", new Object[]{Rollno.getText().toString()});
                showMessage("Success", "Record Deleted");
            } else {
                showMessage("Error", "Invalid Rollno");
            }
            c.close();
            clearText();
        }
        // Updating a record in the Student table
        else if (view == Update) {
            // Checking for empty roll number
            if (Rollno.getText().toString().trim().isEmpty()) {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno = ?", new String[]{Rollno.getText().toString()});
            if (c.moveToFirst()) {
                db.execSQL("UPDATE student SET name = ?, marks = ? WHERE rollno = ?",
                        new Object[]{Name.getText().toString(), Marks.getText().toString(), Rollno.getText().toString()});
                showMessage("Success", "Record Modified");
            } else {
                showMessage("Error", "Invalid Rollno");
            }
            c.close();
            clearText();
        }
        // Display a record from the Student table
        else if (view == View) {
            // Checking for empty roll number
            if (Rollno.getText().toString().trim().isEmpty()) {
                showMessage("Error", "Please enter Rollno");
                return;
            }
            Cursor c = db.rawQuery("SELECT * FROM student WHERE rollno = ?", new String[]{Rollno.getText().toString()});
            if (c.moveToFirst()) {
                Name.setText(c.getString(1));
                Marks.setText(c.getString(2));
            } else {
                showMessage("Error", "Invalid Rollno");
                clearText();
            }
            c.close();
        }
        // Displaying all the records
        else if (view == ViewAll) {
            Cursor c = db.rawQuery("SELECT * FROM student", null);
            if (c.getCount() == 0) {
                showMessage("Error", "No records found");
                return;
            }
            StringBuilder buffer = new StringBuilder();
            while (c.moveToNext()) {
                buffer.append("Rollno: ").append(c.getString(0)).append("\n");
                buffer.append("Name: ").append(c.getString(1)).append("\n");
                buffer.append("Marks: ").append(c.getString(2)).append("\n\n");
            }
            showMessage("Student Details", buffer.toString());
            c.close();
        }
    }

    public void showMessage(String title, String message) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearText() {
        Rollno.setText("");
        Name.setText("");
        Marks.setText("");
        Rollno.requestFocus();
    }
}
