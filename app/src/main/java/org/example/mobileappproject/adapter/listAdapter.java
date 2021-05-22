package org.example.mobileappproject.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.example.mobileappproject.R;
import org.example.mobileappproject.data.DatabaseHelper;
import org.example.mobileappproject.data.Staff;

import java.util.ArrayList;


public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder> {

    private ArrayList<Staff> staffList = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView wageTextView;

        ViewHolder(View itemView) {
            super(itemView) ;

            nameTextView = itemView.findViewById(R.id.nameTextView);
            wageTextView = itemView.findViewById(R.id.wageTextView);
        }
    }

    public listAdapter(ArrayList<Staff> list){
        staffList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.layout_item,parent,false);
        listAdapter.ViewHolder viewHolder = new listAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Staff staff = staffList.get(position);
        holder.nameTextView.setText(staff.getStaff_id());
        holder.wageTextView.setText(Integer.toString(staff.getWage()));
    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }
}