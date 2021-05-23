package org.example.mobileappproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.example.mobileappproject.R;
import org.example.mobileappproject.data.DatabaseHelper;
import org.example.mobileappproject.data.Staff;

public class registerActivity extends AppCompatActivity implements View.OnClickListener {
//Student Data Insert

    EditText nameView;
    EditText wageView;
    Button registerBtn;
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameView=(EditText)findViewById(R.id.add_name);
        wageView=(EditText)findViewById(R.id.add_wage);
        registerBtn=(Button)findViewById(R.id.btnRegister);

        helper = new DatabaseHelper(this);

        registerBtn.setOnClickListener(this);

    }

    // 등록 버튼 클릭 시
    @Override
    public void onClick(View v) {
        String name =nameView.getText().toString();
        String wage =wageView.getText().toString();

        // 실패
        if(name==null || name.equals("") || wage==null || wage.equals("")){
            Toast t = Toast.makeText(this, R.string.add_name_null, Toast.LENGTH_SHORT );
            t.show();
        }
        // 성공
        else {
            Staff staff = new Staff(name,Integer.parseInt(wage));
            helper.insertStaff(staff);
            Toast.makeText(this, "이름 : "+name+"임금 : "+wage+" 삽입 성공.", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}