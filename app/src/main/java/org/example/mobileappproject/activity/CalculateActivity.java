package org.example.mobileappproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.example.mobileappproject.R;
import org.example.mobileappproject.adapter.CalculateAdapter;
import org.example.mobileappproject.adapter.ScheduleListAdapter;
import org.example.mobileappproject.adapter.listAdapter;
import org.example.mobileappproject.data.DatabaseHelper;
import org.example.mobileappproject.data.MonthWage;
import org.example.mobileappproject.data.Schedule;
import org.example.mobileappproject.data.Staff;

import java.util.ArrayList;

public class CalculateActivity extends AppCompatActivity {

    private CalculateAdapter myAdapter;
    RecyclerView recyclerView;
    ArrayList<MonthWage> monthWages = new ArrayList<>();
    DatabaseHelper helper;

    int year;
    int month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        // 받아온 날짜 할당
        year = getIntent().getIntExtra("year",2000);
        month = getIntent().getIntExtra("month",1);


        helper = new DatabaseHelper(this);
        monthWages = helper.monthTime(year,month);

        if(monthWages.isEmpty()){
            Toast.makeText(this,  year+"년 "+ month +"월 월급 대상자가 없습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }

        recyclerView = this.findViewById(R.id.calRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new CalculateAdapter(monthWages);
        recyclerView.setAdapter(myAdapter);
    }
}