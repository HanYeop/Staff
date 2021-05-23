package org.example.mobileappproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import org.example.mobileappproject.R;
import org.example.mobileappproject.dialog.ScheduleAddActivity;
import org.example.mobileappproject.dialog.ScheduleListActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";
    private CalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = year + "/" +  (month+1) + "/" + dayOfMonth;
                //Log.d(TAG, "onSelectDayChange: date: " + date); //날짜 변환 확인을 위한 log

                AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this); //, android.R.style.Theme_DeviceDefault_Light_Dialog);
                ad.setIcon(R.mipmap.ic_launcher);
                ad.setTitle(date);

                ad.setPositiveButton("근무시간 확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(getApplicationContext(), ScheduleListActivity.class);
                        startActivity(intent);
                    }
                });
                ad.setNegativeButton("근무 추가", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent intent = new Intent(getApplicationContext(), ScheduleAddActivity.class);
                        intent.putExtra("date",date);
                        startActivity(intent);
                    }
                });
                ad.show();
            }
        });


        // 알바생 등록을 위한 버튼
        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), registerActivity.class);
                startActivity(intent);
            }
        });

        // 급여 계산을 위한 버튼
        Button btnCaculator = (Button) findViewById(R.id.btnCaculator);
        btnCaculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), caculateActivity.class);
                startActivity(intent);
            }
        });

        // 리스트 창을 위한 버튼
        Button btnList = (Button) findViewById(R.id.btnList);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(intent);
            }
        });

    }
}