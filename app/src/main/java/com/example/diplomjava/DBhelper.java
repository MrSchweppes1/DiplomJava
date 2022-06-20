package com.example.diplomjava;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AccountingOfWorkshops";
    public static final String TABLE_Groups = "Groups";
    public static final String TABLE_Equipment = "Equipment";
    public static final String TABLE_Event = "Event";

    public static final String Groups_ID = "id";
    public static final String Groups_GROUPNAME = "groupname";
    public static final String Groups_SURENAME = "surename";
    public static final String Groups_NAME = "name";
    public static final String Groups_PATRONYMIC= "patronymic";

    public static final String Equipment_ID = "id";
    public static final String Equipment_TitleEquip = "title_equip";
    public static final String Equipment_SUBTITLE = "subtitle";


    public static final String EventList_ID = "id";
    public static final String EventList_Workshops = "workshops";
    public static final String EventList_LessonType = "lessonType";
    public static final String EventList_Topic = "topic";
    public static final String EventList_Exercise = "exercise";
    public static final String EventList_Criteria = "criteria";
    public static final String EventList_GroupNameID = "groupnameID";
    public static final String EventList_Date = "date";
    public static final String EventList_EquipmentName = "equipmentName";
    public static final String EventList_EquipmentCount = "equipmentCount";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_Groups + "(" + Groups_ID
                + " integer primary key," + " text," + Groups_GROUPNAME + " text," + Groups_SURENAME + " text,"
                + Groups_NAME + " text," + Groups_PATRONYMIC +  " text" + ")");


        db.execSQL("create table " + TABLE_Equipment + "("
                + Equipment_ID
                + " integer primary key," + " text," + Equipment_TitleEquip + " text," + Equipment_SUBTITLE + " text" + ")");

        db.execSQL("create table " + TABLE_Event + "(" + EventList_ID
                + " integer primary key," + " text," + EventList_Workshops + " text," + EventList_LessonType + " text,"
                + EventList_Topic + " text," + EventList_Exercise +  " text," + EventList_Criteria +  " text,"
                + EventList_GroupNameID +  " text,"+ EventList_Date +  " text," + EventList_EquipmentName +  " text,"
                + EventList_EquipmentCount +  " int" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_Groups);
        db.execSQL("drop table if exists " + TABLE_Equipment);
        db.execSQL("drop table if exists " + TABLE_Event);
        onCreate(db);

    }
}
