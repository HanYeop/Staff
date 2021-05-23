package org.example.mobileappproject.data;

import java.io.Serializable;

public class Schedule implements Serializable {
    int _id;
    String staff_id;
    int start_time_hour;
    int start_time_min;
    int end_time_hour;
    int end_time_min;
    int year;
    int month;
    int day;
    int wage;
    int time;

    public Schedule(int _id, String staff_id, int start_time_hour, int start_time_min,
                    int end_time_hour, int end_time_min, int year, int month, int day, int wage, int time){
        this._id = _id;
        this.staff_id = staff_id;
        this.start_time_hour = start_time_hour;
        this.start_time_min = start_time_min;
        this.end_time_hour = end_time_hour;
        this.end_time_min = end_time_min;
        this.year = year;
        this.month = month;
        this.day = day;
        this.wage = wage;
        this.time = time;
    }

    public Schedule(String staff_id, int start_time_hour, int start_time_min,
                    int end_time_hour, int end_time_min, int year, int month, int day, int wage, int time){
        this.staff_id = staff_id;
        this.start_time_hour = start_time_hour;
        this.start_time_min = start_time_min;
        this.end_time_hour = end_time_hour;
        this.end_time_min = end_time_min;
        this.year = year;
        this.month = month;
        this.day = day;
        this.wage = wage;
        this.time = time;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public int getStart_time_hour() {
        return start_time_hour;
    }

    public void setStart_time_hour(int start_time_hour) {
        this.start_time_hour = start_time_hour;
    }

    public int getStart_time_min() {
        return start_time_min;
    }

    public void setStart_time_min(int start_time_min) {
        this.start_time_min = start_time_min;
    }

    public int getEnd_time_hour() {
        return end_time_hour;
    }

    public void setEnd_time_hour(int end_time_hour) {
        this.end_time_hour = end_time_hour;
    }

    public int getEnd_time_min() {
        return end_time_min;
    }

    public void setEnd_time_min(int end_time_min) {
        this.end_time_min = end_time_min;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
