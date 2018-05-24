package com.example.asus.zneku.myfirstandroid.DataBase;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Asus on 5/23/2018.
 */

public class MyDataBase extends SQLiteOpenHelper {
    private final Context context;
    private String Table_Name="contact";
    private String NAME="name";
    private String FAMILY="family";
    private String ID="_id";
    private String Creat_Table=" CREATE TABLE "+Table_Name+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" TEXT, "+FAMILY+" TEXT );";
    public  MyDataBase(Context context){
        super(context,"MyDataBase",null,2);
        this.context=context;
        Toast.makeText(context, "creatDataBase", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Creat_Table);
        Toast.makeText(context, "on", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE "+Table_Name+" ADD COLUMN s NAME TEXT;");
        Toast.makeText(context, "Up", Toast.LENGTH_SHORT).show();
    }
}
