package com.example.diplomjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AddEquipment extends AppCompatActivity implements View.OnClickListener {
    ImageView arrowBack, CheckList, AddStudent;
    Button btnSave;
    DBhelper dbHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_equipment);

        btnSave = (Button) findViewById(R.id.button);


        arrowBack = (ImageView) findViewById(R.id.arrowBack);
        CheckList = (ImageView) findViewById(R.id.CheckList);
        AddStudent = (ImageView) findViewById(R.id.AddStudent);

        dbHelper = new DBhelper(this);
        database = dbHelper.getWritableDatabase();

        UpdateTable();

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

    public void UpdateTable() {
        Cursor cursor = database.query(DBhelper.TABLE_Equipment, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(DBhelper.Equipment_ID);
            int titleIndex = cursor.getColumnIndex(DBhelper.Equipment_TitleEquip);

            TableLayout layOutput = findViewById(R.id.TabLay);
            layOutput.removeAllViews();

            do {
                TableRow TBrow = new TableRow(this);
                TBrow.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

                TextView outputID = new TextView(this);
                params.weight = 1.0f;
                outputID.setLayoutParams(params);
                outputID.setText(cursor.getString(idIndex));
                TBrow.addView(outputID);

                CheckBox outputTitle = new CheckBox(this);
                params.weight = 2.0f;
                outputTitle.setLayoutParams(params);
                outputTitle.setText(cursor.getString(titleIndex));
                TBrow.addView(outputTitle);


                EditText outputSubtitle = new EditText(this);
                params.weight = 1.0f;
                outputSubtitle.setLayoutParams(params);
                outputSubtitle.setText(cursor.getString(1));
                TBrow.addView(outputSubtitle);


                layOutput.addView(TBrow);


            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}