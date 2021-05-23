package org.example.mobileappproject.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import org.example.mobileappproject.R;
import org.example.mobileappproject.adapter.ScheduleListAdapter;
import org.example.mobileappproject.adapter.listAdapter;
import org.example.mobileappproject.data.DatabaseHelper;
import org.example.mobileappproject.data.Schedule;
import org.example.mobileappproject.data.Staff;

import java.util.ArrayList;

public class ScheduleListActivity extends AppCompatActivity {

    private ScheduleListAdapter myAdapter;
    RecyclerView recyclerView;
    ArrayList<Schedule> scheduleList = new ArrayList<>();
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_schedule_list);

        // 받아온 날짜 할당
        String date = getIntent().getStringExtra("date");
        int year = getIntent().getIntExtra("year",2000);
        int month = getIntent().getIntExtra("month",1);
        int day = getIntent().getIntExtra("day",1);

        helper = new DatabaseHelper(this);
        scheduleList = helper.searchSchedule(year,month,day);

        if(scheduleList.isEmpty()){
            Toast.makeText(this,  date+" 일정이 없습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }

        recyclerView = this.findViewById(R.id.schRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new ScheduleListAdapter(scheduleList);
        recyclerView.setAdapter(myAdapter);
    }
}