package com.example.students_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    static LinkedList<Student> students = new LinkedList<>();
//    Student s = new Student("adi","f444444","1111","fdf",false);

    //    s.name = "adi"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        students.add(s);
//        students.add(s);
//        students.add(s);
//        students.add(s);
//        students.add(s);
//        students.add(s);
//        students.add(s);
//        students.add(s);
//        students.add(s);
//        students.add(s);

    }


    @Override
    protected void onStart() {
        super.onStart();
        RecyclerView list = findViewById(R.id.studentlist_list);
        list.hasFixedSize();
        list.setLayoutManager(new LinearLayoutManager(this));
        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Log.d("TAG", "Row was clicked " + pos);
                Intent intent = new Intent(MainActivity.this, DetailsStudent.class);
                intent.putExtra("position", pos);
                MainActivity.this.startActivity(intent);
            }
        });


    }

    public void b_addStudent(View view) {
       startActivity( new Intent(this, AddStudent.class));
    }
    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        TextView idTv;
        CheckBox cb;

        public StudentViewHolder(View itemView, OnItemClickListener listener){
            super(itemView);
            nameTv = itemView.findViewById(R.id.text_s);
            idTv = itemView.findViewById(R.id.id_s);
            cb = itemView.findViewById(R.id.s_check_box);
            cb.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    int pos = (int)cb.getTag();
                    Student st = students.get(pos);
                    st.cb = cb.isChecked();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    listener.onItemClick(pos);
                }
            });

        }

        public void bind(Student st, int pos){
            nameTv.setText(st.name);
            idTv.setText(st.id);
            cb.setChecked(st.cb);
            cb.setTag(pos);
        }

    }

    public interface OnItemClickListener{
        void onItemClick(int pos);
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder>{

        OnItemClickListener listener;

        void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }

        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student, parent, false);

            return new StudentViewHolder(view, listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            Student st = students.get(position);
            holder.bind(st, position);
        }

        @Override
        public int getItemCount() {
            return students.size();
        }
    }
}