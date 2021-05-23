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
    private static final String scheduleTable = "tb_schedule";
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

        String scheduleSql = "CREATE TABLE if not exists " + scheduleTable + "("
                + "_id integer primary key autoincrement,"
                + "name text not null,"
                + "start_hour integer,"
                + "start_min integer,"
                + "end_hour integer,"
                + "end_min integer,"
                + "year integer,"
                + "month integer,"
                + "day integer,"
                + "wage integer,"
                + "time integer)";


        db.execSQL(staffSql);
        db.execSQL(scheduleSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 변경될 때마다 호출되는 함수
        if(newVersion == DATABASE_VERSION){
            db.execSQL("drop table "+staffTable);
            db.execSQL("drop table "+scheduleTable);
            onCreate(db);
        }
    }

    // 직원 추가
    public void insertStaff(Staff staff){
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

    // 직원 시급 조회
    public int searchStaff(String staffName){
        int wage = 0;

        String sql = "SELECT wage FROM "+staffTable+" WHERE name = '"+staffName+"'";

        Cursor results = db.rawQuery(sql,null);

        results.moveToFirst();

        if(results.getCount() == 0){
            results.close();
            return wage;
        }
        else {
            wage = results.getInt(0);
        }

        results.close();
        return wage;
    }


    // 일정 추가
    public void insertSchedule(Schedule schedule){
        String sql = "INSERT INTO "+scheduleTable+" VALUES(NULL, '"+schedule.staff_id+"', "+schedule.start_time_hour+", "+schedule.start_time_min+", "+schedule.end_time_hour+", "+schedule.end_time_min+", "+schedule.year+", "+schedule.month+", "+schedule.day+", "+schedule.wage+", "+schedule.time+");";
        db.execSQL(sql);
    }

    // 그 날의 일정 조회
    public ArrayList<Schedule> searchSchedule(int year, int month, int day){
        String sql = "SELECT * FROM "+scheduleTable+" WHERE year = "+year+" AND month = "+month+" AND day = "+day+" ORDER BY start_hour ASC, start_min ASC";

        ArrayList<Schedule> list = new ArrayList<>();

        Cursor results = db.rawQuery(sql,null);
        results.moveToFirst();

        while(!results.isAfterLast()){
            Schedule schedule = new Schedule(results.getInt(0),results.getString(1),results.getInt(2),results.getInt(3)
                    ,results.getInt(4),results.getInt(5),results.getInt(6),results.getInt(7),results.getInt(8),results.getInt(9),results.getInt(10));
            list.add(schedule);
            results.moveToNext();
        }

        results.close();
        return list;
    }

    // 직원 월 근로자 조회
    public ArrayList<MonthWage> monthTime(int year, int month){
        String sql = "SELECT _id, name, wage, SUM(time) FROM "+scheduleTable+" WHERE year = "+year+" AND month = "+month+" GROUP BY name";

        ArrayList<MonthWage> list = new ArrayList<>();

        Cursor results = db.rawQuery(sql,null);
        results.moveToFirst();

        while(!results.isAfterLast()){
            MonthWage monthWage = new MonthWage(results.getInt(0),results.getString(1),results.getInt(2),results.getInt(3));
            list.add(monthWage);
            results.moveToNext();
        }
        results.close();
        return list;
    }
}