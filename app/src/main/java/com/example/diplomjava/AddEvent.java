package com.example.diplomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AddEvent extends AppCompatActivity implements View.OnClickListener{
    ImageView arrowBack, CheckList, AddStudent;
    Button btnEquip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);


        arrowBack = (ImageView) findViewById(R.id.arrowBack);
        CheckList = (ImageView) findViewById(R.id.CheckList);
        AddStudent = (ImageView) findViewById(R.id.AddStudent);

        btnEquip = (Button) findViewById(R.id.button2);

        CheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEvent.this, ChecklistPage.class);
                startActivity(intent);
            }
        });

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEvent.this, MainActivity.class);
                startActivity(intent);
            }
        });

        AddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddEvent.this, AddStudent.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;

        switch (v.getId()) {

            case R.id.button2:

                Intent intent = new Intent(this, AddEquipment.class);
                startActivity(intent);
                break;


            default:

                break;
        }
    }
}