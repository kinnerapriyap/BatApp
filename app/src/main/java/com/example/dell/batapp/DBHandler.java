package com.example.dell.batapp;

/**
 * Created by Dell on 1/14/2015.
 */

        import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static int DATABASE_VERSION= 1;
    private static final String DATABASE_NAME= "criminaldatabase";
    private static final String TABLE_NAME= "criminaldata";
    private static final String KEY_ID= "criminalid";
    private static final String KEY_NAME= "criminalname";
    private static final String KEY_AGE= "criminalage";
    private static final String KEY_CRIMES= "criminalcrimes";
    private static final String KEY_LOCATION= "criminallocation";
    private static final String KEY_GENDER= "criminalgender";
    //private static final String KEY_IMAGE= "crminalimage";
    private static final String DATABASE_CREATE= "create table "+TABLE_NAME+
            "("+KEY_ID+" INTEGER PRIMARY KEY,"
            +KEY_NAME+" TEXT,"
            +KEY_AGE+" TEXT,"
            +KEY_GENDER+" TEXT,"
            +KEY_CRIMES+" TEXT,"
            +KEY_LOCATION+" TEXT)";
    ArrayList<Criminal> criminal_list= new ArrayList<Criminal>();
    Context context;
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL("drop table "+TABLE_NAME);
        onCreate(db);

    }

    public long addcriminal(Criminal criminal) {
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(KEY_NAME, criminal.getName());
        values.put(KEY_AGE, criminal.getAge());
        values.put(KEY_GENDER, criminal.getGender());
        values.put(KEY_CRIMES, criminal.getCrimes());
        values.put(KEY_LOCATION, criminal.getLocation());
        //values.put(KEY_IMAGE, criminal.getImage());
        long l= db.insert(TABLE_NAME, null, values);
        db.close();
        return l;
    }

    public int updatecriminal(Criminal criminal, int id) {
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(KEY_NAME, criminal.getName());
        values.put(KEY_AGE, criminal.getAge());
        values.put(KEY_GENDER, criminal.getGender());
        values.put(KEY_CRIMES, criminal.getCrimes());
        values.put(KEY_LOCATION, criminal.getLocation());
        //values.put(KEY_IMAGE, criminal.getImage());
        Toast.makeText(context,"Name:"+criminal.getName()+" , Age:"+criminal.getAge()+" , Gender:"+criminal.getGender()+" , Crimes:"+criminal.getCrimes()+" , Location:"+criminal.getLocation()+" "+id,Toast.LENGTH_SHORT).show();
        int l=db.update(TABLE_NAME, values, KEY_ID+"="+id, null);

        return l;
    }

    public void deletecriminal(int id) {
        SQLiteDatabase db= getWritableDatabase();
        db.delete(TABLE_NAME,KEY_ID+"="+id,null);
    }
    public ArrayList<Criminal> getCriminal() {
        criminal_list.clear();
        String select_Query= "select * from " +TABLE_NAME;
        SQLiteDatabase db= getWritableDatabase();
        Cursor cursor=db.rawQuery(select_Query, null);
        if(cursor.moveToFirst()) {
            do {
                Criminal criminal= new Criminal("","","","","");
                criminal.setId(String.valueOf(cursor.getInt(0)));
                criminal.setName(cursor.getString(1));
                criminal.setAge(cursor.getString(2));
                criminal.setGender(cursor.getString(3));
                criminal.setCrimes(cursor.getString(4));
                criminal.setLocation(cursor.getString(5));
                //criminal.setImage(cursor.getString(6));
                criminal_list.add(criminal);
            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return criminal_list;
    }

}

