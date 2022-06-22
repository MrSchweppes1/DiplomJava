package com.example.diplomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity implements View.OnClickListener{
    Button btnAddStudent;
    ImageView HomePage, CheckList, AddStudent;
    EditText groupname, surename, name, patronymic;
    DBhelper dbHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        btnAddStudent = (Button) findViewById(R.id.btnAddStudent);

        HomePage = (ImageView) findViewById(R.id.HomePage);
        CheckList = (ImageView) findViewById(R.id.CheckList);
        AddStudent = (ImageView) findViewById(R.id.AddStudent);

        groupname = (EditText) findViewById(R.id.groupname);
        surename = (EditText) findViewById(R.id.surename);
        name = (EditText) findViewById(R.id.name);
        patronymic = (EditText) findViewById(R.id.patronymic);

        dbHelper = new DBhelper(this);
        database = dbHelper.getWritableDatabase();

        CheckList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddStudent.this, ChecklistPage.class);
                startActivity(intent);
            }
        });

        HomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddStudent.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;

        switch (v.getId()) {

            case R.id.btnAddStudent:
                Cursor find = database.query(DBhelper.TABLE_Groups,null,null,null,null,null,null);

                boolean logged = false;

                if(find.moveToNext()) {
                    int Groups_GROUPNAME = find.getColumnIndex(DBhelper.Groups_GROUPNAME);
                    int Groups_SURENAME = find.getColumnIndex(DBhelper.Groups_SURENAME);
                    int Groups_NAME = find.getColumnIndex(DBhelper.Groups_NAME);
                    int Groups_PATRONYMIC = find.getColumnIndex(DBhelper.Groups_PATRONYMIC);
                    do {
                        if (groupname.getText().toString().equals(find.getString(Groups_GROUPNAME)) && surename.getText().toString().equals(find.getString(Groups_SURENAME))
                                && name.getText().toString().equals(find.getString(Groups_NAME)) && patronymic.getText().toString().equals(find.getString(Groups_PATRONYMIC))) {
                            Toast.makeText(this, "Данный студент уже есть в системе", Toast.LENGTH_LONG).show();
                            logged = true;
                            break;
                        }
                    } while (find.moveToNext());

                }
                if(!logged)
                {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DBhelper.Groups_GROUPNAME,groupname.getText().toString());
                    contentValues.put(DBhelper.Groups_SURENAME,surename.getText().toString());
                    contentValues.put(DBhelper.Groups_NAME,name.getText().toString());
                    contentValues.put(DBhelper.Groups_PATRONYMIC,patronymic.getText().toString());
                    database.insert(DBhelper.TABLE_Groups,null,contentValues);
                    Toast.makeText(this, "Успешная регистрация", Toast.LENGTH_LONG).show();
                }
                find.close();

                groupname.setText("");
                surename.setText("");
                name.setText("");
                patronymic.setText("");
                break;


            default:

                break;
        }
    }
}