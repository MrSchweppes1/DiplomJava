package com.example.diplomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AddEquipment extends AppCompatActivity implements View.OnClickListener{
    ImageView arrowBack, CheckList, AddStudent;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_equipment);

        btnSave = (Button) findViewById(R.id.button);


        arrowBack = (ImageView) findViewById(R.id.arrowBack);
        CheckList = (ImageView) findViewById(R.id.CheckList);
        AddStudent = (ImageView) findViewById(R.id.AddStudent);


        CheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEquipment.this, ChecklistPage.class);
                startActivity(intent);
            }
        });

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEquipment.this, AddEvent.class);
                startActivity(intent);
            }
        });

        AddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEquipment.this, AddStudent.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;

        switch (v.getId()) {

            case R.id.button:

                Intent intent = new Intent(this, ChecklistPage.class);
                startActivity(intent);
                break;


            default:

                break;
        }
    }
}