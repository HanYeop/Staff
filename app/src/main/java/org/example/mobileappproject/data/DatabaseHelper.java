package org.example.mobileappproject.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String dbName = "mainDB";
    private static final String staffTable = "tb_staff";
    private static final int DATABASE_VERSION =1;

    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context,dbName, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //application install 이후 최초의 한번 실행되는 함수
        //table create
        String staffSql = "CREATE TABLE if not exists " + staffTable + "("
                + "_id integer primary key autoincrement,"
                + "name text not null,"
                + "wage integer)";

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
            db.execSQL("drop table "+staffTable);
//            db.execSQL("drop table tb_schedule");
            onCreate(db);
        }
    }

    // 직원 추가
    public void insertStaff(Staff staff){
        Log.d("test5", "삽입되었다. ");
        String sql = "INSERT INTO "+staffTable+" VALUES(NULL, '"+staff.staff_id+"', "+staff.wage+");";
        db.execSQL(sql);
    }

    // 직원 조회
    public ArrayList<Staff> selectAll(){
        String sql = "SELECT * FROM "+ staffTable;

        ArrayList<Staff> list = new ArrayList<>();

        Cursor results = db.rawQuery(sql,null);
        results.moveToFirst();

        while(!results.isAfterLast()){
            Staff staff = new Staff(results.getInt(0),results.getString(1),results.getInt(2));
            list.add(staff);
            results.moveToNext();
        }
        results.close();
        return list;
    }
}