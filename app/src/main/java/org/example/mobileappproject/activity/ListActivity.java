package org.example.mobileappproject.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.example.mobileappproject.R;
import org.example.mobileappproject.adapter.listAdapter;
import org.example.mobileappproject.data.DatabaseHelper;
import org.example.mobileappproject.data.Staff;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private listAdapter myAdapter;
    RecyclerView recyclerView;
    ArrayList<Staff> staffList = new ArrayList<>();
    DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        helper = new DatabaseHelper(this);
        staffList = helper.selectAll();

        recyclerView = this.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new listAdapter(staffList);
        recyclerView.setAdapter(myAdapter);
    }
}