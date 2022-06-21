package com.example.diplomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnAddEvent, btnNewEquipment;
    Toast toast;
    SQLiteDatabase database;
    Spinner spinner;

    ImageView HomePage, CheckList, AddStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddEvent = (Button) findViewById(R.id.btnAddStudent);
        btnNewEquipment = (Button) findViewById(R.id.btnNewEquipment);

        HomePage = (ImageView) findViewById(R.id.HomePage);
        CheckList = (ImageView) findViewById(R.id.CheckList);
        AddStudent = (ImageView) findViewById(R.id.AddStudent);


        CheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChecklistPage.class);
                startActivity(intent);
            }
        });

        AddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddStudent.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;

        switch (v.getId()) {

            case R.id.btnAddStudent:

                Intent intent = new Intent(this, AddEvent.class);
                startActivity(intent);
                break;

            case R.id.btnNewEquipment:
                intent = new Intent(this, NewEquipment.class);
                startActivity(intent);
                break;
            default:

                break;
        }
    }
}