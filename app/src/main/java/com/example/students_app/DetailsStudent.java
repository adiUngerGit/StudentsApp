package com.example.students_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

public class DetailsStudent extends AppCompatActivity {

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details_student);


        super.onStart();
        Intent intent = getIntent();
        pos = (intent.getIntExtra("position", -1));
        Log.d("edit",intent.getStringExtra("position") + "");

        TextView name = findViewById(R.id.name_d);
        TextView id = findViewById(R.id.id_d);
        TextView phon = findViewById(R.id.phon_d);
        TextView adress = findViewById(R.id.address_d);
        CheckBox cb = findViewById(R.id.cb_d);


        name.setText("Name: " + MainActivity.students.get(pos).name);
        id.setText("ID: " + MainActivity.students.get(pos).id);
        phon.setText("Phone: " + MainActivity.students.get(pos).phon);
        adress.setText("Address: " + MainActivity.students.get(pos).address);
        cb.setChecked(MainActivity.students.get(pos).cb);
        findViewById(R.id.edit_b_d)
                .setOnClickListener(view -> startActivity(
                        new Intent(this, EditStudent.class)
                                .putExtra("studentRow", pos)
                ));

    }
}