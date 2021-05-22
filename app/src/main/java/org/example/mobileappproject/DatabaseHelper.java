package org.example.mobileappproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;

    public DatabaseHelper(Context context) {
        super(context,"staff", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //application install 이후 최초의 한번 실행되는 함수
        //table create
        String staffSql = "CREATE TABLE if not exists tb_staff ("
                + "_id integer primary key autoincrement,"
                + "name not null,"
                + "wage)";

//        String scheduleSql = "CREATE TABLE if not exists tb_schedule ("
//                + "_id integer primary key autoincrement,"
//                + "staff_id not null,"
//                + "wage"
//                +"date)";

        db.execSQL(staffSql);
//        db.execSQL(scheduleSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 변경될 때마다 호출되는 함수
        if(newVersion == DATABASE_VERSION){
            db.execSQL("drop table tb_staff");
//            db.execSQL("drop table tb_schedule");
            onCreate(db);

        }

    }
}