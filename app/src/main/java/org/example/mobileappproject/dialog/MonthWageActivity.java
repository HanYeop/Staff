package org.example.mobileappproject.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.example.mobileappproject.R;
import org.example.mobileappproject.activity.CalculateActivity;

import static android.widget.Toast.*;

public class MonthWageActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    EditText yearText;
    EditText monthText;

    String year;
    String month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_month_wage);

        button = findViewById(R.id.moveButton);
        yearText = findViewById(R.id.yearEditView);
        monthText = findViewById(R.id.monthEditView);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        year = yearText.getText().toString();
        month = monthText.getText().toString();

        // 값 미입력시
        if(year==null || year.equals("") || month==null || month.equals("")){
            makeText(this, "값을 입력해주세요.", LENGTH_SHORT).show();
        }

        else{
            int i_year = Integer.parseInt(year);
            int i_month = Integer.parseInt(month);
            Intent intent = new Intent(getApplicationContext(), CalculateActivity.class);
            intent.putExtra("year",i_year);
            intent.putExtra("month",i_month);
            startActivity(intent);
            finish();
        }
    }
}