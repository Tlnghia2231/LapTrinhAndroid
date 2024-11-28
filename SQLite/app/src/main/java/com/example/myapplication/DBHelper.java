package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper  extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context){
        super(context, "SQLite_Number.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table Num(id TEXT Primary Key, number INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table if exists Num");
    }

    public Boolean insert(String id, int number)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("number", number);
        long result = db.insert("Num", null, cv);
        db.close();
        if (result != -1) return true;
        else return false;
    }

    public Boolean update(String id, int number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        cv.put("number", number);
        long result = db.update("Num", cv, "id = ?", new String[] {id});
        db.close();
        if (result != -1) return true;
        else return false;
    }

    public Boolean delete(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", id);
        long result = db.delete("Num", "id = ?", new String[]{id});
        db.close();
        if (result != -1) return true;
        else return false;
    }

    public List<Number> show() {
        List<Number> l_number = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("Select * From Num", null);
        if (cr.moveToFirst()) {
            do {
                String id = cr.getString(0);
                int number = cr.getInt(1);
                l_number.add(new Number(id, number));
            } while (cr.moveToNext());
        }
        cr.close();
        return l_number;
    }

}
