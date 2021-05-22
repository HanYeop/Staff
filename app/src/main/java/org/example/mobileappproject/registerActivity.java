package org.example.mobileappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registerActivity extends AppCompatActivity implements View.OnClickListener {
//Student Data Insert

    EditText nameView;
    EditText wageView;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameView=(EditText)findViewById(R.id.add_name);
        wageView=(EditText)findViewById(R.id.add_wage);
        registerBtn=(Button)findViewById(R.id.btnRegister);

        registerBtn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        String name =nameView.getText().toString();
        String wage =wageView.getText().toString();

        if(name==null || name.equals("")){
            Toast t = Toast.makeText(this, R.string.add_name_null, Toast.LENGTH_SHORT );
            t.show();
        }
        else {
            DatabaseHelper helper = new DatabaseHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL("insert into tb_staff(name, wage) values (?,?,?)",
                new String[]{name,wage});
            db.close();

            finish();;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}