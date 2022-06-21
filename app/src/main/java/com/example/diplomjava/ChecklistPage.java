package com.example.diplomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChecklistPage extends AppCompatActivity {
    ImageView HomePage, CheckList, AddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist_page);


        HomePage = (ImageView) findViewById(R.id.HomePage);
        CheckList = (ImageView) findViewById(R.id.CheckList);
        AddStudent = (ImageView) findViewById(R.id.AddStudent);


        AddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChecklistPage.this, AddStudent.class);
                startActivity(intent);
            }
        });

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChecklistPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}