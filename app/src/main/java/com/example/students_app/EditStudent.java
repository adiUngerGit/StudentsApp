package com.example.students_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class EditStudent extends AppCompatActivity {
    int pos;
    EditText name,id,phon,adress;
    CheckBox cb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        Intent intent = getIntent();
        pos = (intent.getIntExtra("studentRow", -1));
        Log.d("edit position", pos + "");
        name = findViewById(R.id.fill_name);
        id = findViewById(R.id.fill_id);
        phon = findViewById(R.id.fill_phon);
        adress = findViewById(R.id.fill_address);
        cb = findViewById(R.id.checkBox_edit);


        name.setText(MainActivity.students.get(pos).name);
        id.setText(MainActivity.students.get(pos).id);
        phon.setText(MainActivity.students.get(pos).phon);
        adress.setText(MainActivity.students.get(pos).address);
        cb.setChecked(MainActivity.students.get(pos).cb);
    }

    public void cencel(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);     }

    public void delet_b_edit(View view) {
        MainActivity.students.remove(MainActivity.students.get(pos));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent); }

    public void save_b_edit(View view) {
        String s = name.getText().toString();
        MainActivity.students.get(pos).setName(name.getText().toString());
        MainActivity.students.get(pos).setId(id.getText().toString());
        MainActivity.students.get(pos).setPhone(phon.getText().toString());
        MainActivity.students.get(pos).setAddress(adress.getText().toString());
        MainActivity.students.get(pos).setCb(cb.isChecked());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}