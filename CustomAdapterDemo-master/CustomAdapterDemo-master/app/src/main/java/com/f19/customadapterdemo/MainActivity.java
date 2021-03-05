package com.f19.customadapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    List<Students> StudentList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

         StudentList = new ArrayList<>();

        for (int i = 1; i <= 20 ; i++) {

            Students student = new Students("student" + i , i, "student"+i+"@mail.com",i*5);
            StudentList.add(student);
        }

        StudentAdapter personAdapter = new StudentAdapter(this, R.layout.person_layout, StudentList);
        listView.setAdapter(personAdapter);
//------------------------------------------------------------------------------------------------//
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Students person = StudentList.get(new Random().nextInt(StudentList.size()));
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("student", person);
                startActivity(intent);
            }
        });


    }
}
