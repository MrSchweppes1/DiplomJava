package com.example.diplomjava;

import static com.example.diplomjava.DBhelper.Groups_GROUPNAME;
import static com.example.diplomjava.DBhelper.TABLE_Groups;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddEvent extends AppCompatActivity implements View.OnClickListener{
    ImageView arrowBack, CheckList, AddStudent;
    Button btnEquip;
    EditText criteria,exercize,topicLesson;
    TextView tvWorkshops;
    CalendarView calendarView;
    Spinner groupName, spinner2;
    public Context mContext;

    DBhelper dbHelper;
    SQLiteDatabase database;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        tvWorkshops = (TextView) findViewById(R.id.tvWorkshops);

        Bundle arguments = getIntent().getExtras();
        if(arguments !=null) {
            String wsName = arguments.get("ws").toString();
            tvWorkshops.setText(wsName);
        }
        criteria = (EditText) findViewById(R.id.criteria);
        exercize = (EditText) findViewById(R.id.surename);
        topicLesson = (EditText) findViewById(R.id.topicLesson);
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        arrowBack = (ImageView) findViewById(R.id.arrowBack);
        CheckList = (ImageView) findViewById(R.id.CheckList);
        AddStudent = (ImageView) findViewById(R.id.AddStudent);

        btnEquip = (Button) findViewById(R.id.button2);

        dbHelper = new DBhelper(this);
        database = dbHelper.getWritableDatabase();
        groupName = (Spinner) findViewById(R.id.groupName);

        Cursor c = database.query(TABLE_Groups,null,null,null,null,null,null);


        ArrayList<String> yourStringValues = new ArrayList<String>();
        Cursor result = database.query(true, TABLE_Groups,
                new String[] { Groups_GROUPNAME }, null, null, null, null,
                null, null);

        if (result.moveToFirst()) {
            do {
                yourStringValues.add(result.getString(result.getColumnIndex(Groups_GROUPNAME)));
            } while (result.moveToNext());
        }
        Toast.makeText(this, yourStringValues.toString(), Toast.LENGTH_LONG).show();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, yourStringValues);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        groupName.setAdapter(adapter);



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
                String wsName = tvWorkshops.toString();
                String spinLess = spinner2.getSelectedItem().toString();
                String topLess = topicLesson.toString();
                String exer = exercize.toString();
                String crit = criteria.toString();
                String grname = groupName.getSelectedItem().toString();
                long calView = calendarView.getDate();

                Intent intent = new Intent(this, AddEquipment.class);
                intent.putExtra("wsTvWsh",wsName);
                intent.putExtra("wsSpinLess",spinLess);
                intent.putExtra("wsTopLess",topLess);
                intent.putExtra("wsExer",exer);
                intent.putExtra("wsCrit",crit);
                intent.putExtra("wsGrName",grname);
                intent.putExtra("wsCalendar",calView);
                startActivity(intent);
                break;


            default:

                break;
        }
    }
}