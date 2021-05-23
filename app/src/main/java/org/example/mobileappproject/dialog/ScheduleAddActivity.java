package org.example.mobileappproject.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.example.mobileappproject.R;

public class ScheduleAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_schedule_add);

        TextView dateTextView = findViewById(R.id.dateTextView);

        // 날짜 표시해줌
        String date = getIntent().getStringExtra("date");
        dateTextView.setText(date);

    }
}