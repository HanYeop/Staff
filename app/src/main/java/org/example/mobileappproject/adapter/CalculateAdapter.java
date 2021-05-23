package org.example.mobileappproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.example.mobileappproject.R;
import org.example.mobileappproject.data.MonthWage;

import java.util.ArrayList;

public class CalculateAdapter extends RecyclerView.Adapter<CalculateAdapter.ViewHolder> {

    private ArrayList<MonthWage> monthWages = null;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        TextView wageTextView;
        TextView timeTextView;

        ViewHolder(View itemView){
            super(itemView);

            nameTextView = itemView.findViewById(R.id.nameTextView);
            wageTextView = itemView.findViewById(R.id.wageTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
        }
    }

    public CalculateAdapter(ArrayList<MonthWage> list){
        monthWages = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.layout_cacitem,parent,false);
        CalculateAdapter.ViewHolder viewHolder = new CalculateAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonthWage monthWage = monthWages.get(position);

        String wage = Integer.toString(monthWage.getWage()*monthWage.getTime());
        String time = Integer.toString(monthWage.getTime());

        holder.nameTextView.setText(monthWage.getStaff_id());
        holder.wageTextView.setText(wage);
        holder.timeTextView.setText(time);
    }

    @Override
    public int getItemCount() {
        return monthWages.size();
    }
}

