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

public class NewEquipment extends AppCompatActivity implements View.OnClickListener{
    ImageView HomePage, CheckList, AddStudent,arrowBack;
    Button btnSaveEquip;

    EditText TypeEquip, NameEquip;
    DBhelper dbHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_equipment);


        arrowBack = (ImageView) findViewById(R.id.arrowBack);
        HomePage = (ImageView) findViewById(R.id.HomePage);
        CheckList = (ImageView) findViewById(R.id.CheckList);
        AddStudent = (ImageView) findViewById(R.id.AddStudent);

        NameEquip = (EditText) findViewById(R.id.NameEquip);
        TypeEquip = (EditText) findViewById(R.id.TypeEquip);

        dbHelper = new DBhelper(this);
        database = dbHelper.getWritableDatabase();

    }

    @Override
    public void onClick(View v) {

        Button b = (Button) v;

        switch (v.getId()) {

            case R.id.btnSaveEquip:

                Cursor find = database.query(DBhelper.TABLE_Equipment,null,null,null,null,null,null);

                boolean logged = false;

                if(find.moveToNext()) {
                    int Equipment_TitleEquip = find.getColumnIndex(DBhelper.Equipment_TitleEquip);
                    int Equipment_SUBTITLE = find.getColumnIndex(DBhelper.Equipment_SUBTITLE);
                    do {
                        if (NameEquip.getText().toString().equals(find.getString(Equipment_TitleEquip)) && TypeEquip.getText().toString().equals(find.getString(Equipment_SUBTITLE))) {
                            Toast.makeText(this, "Данное оборудование уже есть в системе", Toast.LENGTH_LONG).show();
                            logged = true;
                            break;
                        }
                    } while (find.moveToNext());

                }
                if(!logged)
                {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DBhelper.Equipment_TitleEquip,NameEquip.getText().toString());
                    contentValues.put(DBhelper.Equipment_SUBTITLE,TypeEquip.getText().toString());
                    database.insert(DBhelper.TABLE_Equipment,null,contentValues);
                    Toast.makeText(this, "Оборудование добавлено", Toast.LENGTH_LONG).show();
                }
                find.close();
                NameEquip.setText("");
                TypeEquip.setText("");
                break;


            default:

                break;
        }
    }


    public void onClickIV(View iv) {

        ImageView imgv = (ImageView) iv;

        switch (iv.getId()) {

            case R.id.arrowBack2:
                Intent intent = new Intent(NewEquipment.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.CheckList:
                intent = new Intent(NewEquipment.this, ChecklistPage.class);
                startActivity(intent);
                break;

            case R.id.AddStudent:
                intent = new Intent(NewEquipment.this, AddStudent.class);
                startActivity(intent);
                break;

            default:

                break;
        }
    }
}