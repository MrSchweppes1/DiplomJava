package com.example.diplomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NewEquipment extends AppCompatActivity implements View.OnClickListener{
    ImageView HomePage, CheckList, AddStudent,arrowBack;
    Button btnSaveEquip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_equipment);


        arrowBack = (ImageView) findViewById(R.id.arrowBack);
        HomePage = (ImageView) findViewById(R.id.HomePage);
        CheckList = (ImageView) findViewById(R.id.CheckList);
        AddStudent = (ImageView) findViewById(R.id.AddStudent);


        CheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEquipment.this, ChecklistPage.class);
                startActivity(intent);
            }
        });

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEquipment.this, MainActivity.class);
                startActivity(intent);
            }
        });

        AddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEquipment.this, AddStudent.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;

        switch (v.getId()) {

            case R.id.btnSaveEquip:



                break;


            default:

                break;
        }
    }
}