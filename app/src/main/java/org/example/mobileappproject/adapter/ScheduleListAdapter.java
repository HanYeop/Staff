package org.example.mobileappproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.example.mobileappproject.R;
import org.example.mobileappproject.data.Schedule;

import java.util.ArrayList;

public class ScheduleListAdapter extends RecyclerView.Adapter<ScheduleListAdapter.ViewHolder> {

    private ArrayList<Schedule> scheduleList = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView startTimeText;
        TextView endTimeText;
        TextView staffNameText;

        ViewHolder(View itemView) {
            super(itemView) ;

            startTimeText = itemView.findViewById(R.id.startTimeText);
            endTimeText = itemView.findViewById(R.id.endTimeText);
            staffNameText = itemView.findViewById(R.id.staffNameText);
        }
    }

    public ScheduleListAdapter(ArrayList<Schedule> list){
        scheduleList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.layout_schitem,parent,false);
        ScheduleListAdapter.ViewHolder viewHolder = new ScheduleListAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Schedule schedule = scheduleList.get(position);
        String s_start_time_hour = Integer.toString(schedule.getStart_time_hour());
        String s_start_time_min = Integer.toString(schedule.getStart_time_min());
        String s_end_time_hour = Integer.toString(schedule.getEnd_time_hour());
        String s_end_time_min = Integer.toString(schedule.getEnd_time_min());


        if (s_start_time_hour.length() == 1) s_start_time_hour = "0" + s_start_time_hour;
        if (s_start_time_min.length() == 1) s_start_time_min = "0" + s_start_time_min;
        if (s_end_time_hour.length() == 1) s_end_time_hour = "0" + s_end_time_hour;
        if (s_end_time_min.length() == 1) s_end_time_min = "0" + s_end_time_min;

        holder.startTimeText.setText(s_start_time_hour + " : " + s_start_time_min);
        holder.endTimeText.setText(s_end_time_hour + " : " + s_end_time_min);
        holder.staffNameText.setText(schedule.getStaff_id());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }
}


