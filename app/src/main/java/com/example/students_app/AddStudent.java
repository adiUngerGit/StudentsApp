package com.example.students_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class AddStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


    }


    public void save_b(View view) {
        TextView name = findViewById(R.id.fill_name);
        TextView id = findViewById(R.id.fill_id);
        TextView phon = findViewById(R.id.fill_phon);
        TextView adress = findViewById(R.id.fill_address);
        CheckBox cb = findViewById(R.id.checkBox_edit);

        Student s = new Student(name.getText().toString(),id.getText().toString(),phon.getText().toString(),adress.getText().toString(),cb.isChecked());

        MainActivity.students.add(s);
        finish();
    }

    public void cencel(View view) {
        finish();
    }
}
