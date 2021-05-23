package org.example.mobileappproject.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.example.mobileappproject.R;
import org.example.mobileappproject.activity.registerActivity;
import org.example.mobileappproject.data.DatabaseHelper;
import org.example.mobileappproject.data.Schedule;
import org.example.mobileappproject.data.Staff;

public class ScheduleAddActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseHelper helper;

    TextView dateTextView;
    Button registerButton;
    EditText staffNameEditView;
    EditText startHourEditView;
    EditText startMinEditView;
    EditText endHourEditView;
    EditText endMinEditView;

    int year;
    int month;
    int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_schedule_add);

        dateTextView = findViewById(R.id.dateTextView);
        registerButton = findViewById(R.id.registerButton);
        staffNameEditView = findViewById(R.id.staffNameEditView);
        startHourEditView = findViewById(R.id.startHourEditView);
        startMinEditView = findViewById(R.id.startMinEditView);
        endHourEditView = findViewById(R.id.endHourEditView);
        endMinEditView = findViewById(R.id.endMinEditView);

        // 날짜 표시해줌
        String date = getIntent().getStringExtra("date");
        dateTextView.setText(date);

        // 받아온 날짜 할당
        year = getIntent().getIntExtra("year",2000);
        month = getIntent().getIntExtra("month",1);
        day = getIntent().getIntExtra("day",1);

        // DB 연결
        helper = new DatabaseHelper(this);

        // 클릭 리스너 연결
        registerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String name = staffNameEditView.getText().toString();
        String startHour = startHourEditView.getText().toString();
        String startMin = startMinEditView.getText().toString();
        String endHour = endHourEditView.getText().toString();
        String endMin = endMinEditView.getText().toString();

        // 입력되지 않은 값이 있을 때
        if(name==null || name.equals("") || startHour==null || startHour.equals("")
                || startMin==null || startMin.equals("") || endHour==null || endHour.equals("") || endMin==null || endMin.equals("")){
            Toast t = Toast.makeText(this, R.string.add_name_null, Toast.LENGTH_SHORT );
            t.show();
        }

        // 다 입력 되있을 때
        else{
            int I_startHour = Integer.parseInt(startHour);
            int I_startMin = Integer.parseInt(startMin);
            int I_endHour = Integer.parseInt(endHour);
            int I_endMin = Integer.parseInt(endMin);
            int wage = helper.searchStaff(name);
            int time = ( ((I_endHour * 60) + I_endMin) - ((I_startHour * 60) + I_startMin) ) / 60;

            // 직원이 없을 때
            if(wage == 0) {
                Toast.makeText(this, "등록된 직원이 아닙니다.", Toast.LENGTH_SHORT).show();
            }

            // 끝나는 시간이 시작 시간보다 작을 때
            else if(I_startHour > I_endHour || ((I_startHour == I_endHour) && I_startMin > I_endMin)){
                Toast.makeText(this, "끝나는 시간은 시작 시간보다 빠를 수 없습니다.", Toast.LENGTH_SHORT).show();
            }

            // 등록된 직원이 있을 때 (성공)
            else {
                Schedule schedule = new Schedule(name, I_startHour, I_startMin, I_endHour, I_endMin, year, month, day, wage, time);
                helper.insertSchedule(schedule);
                Toast.makeText(this, "스케줄 추가 완료", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}