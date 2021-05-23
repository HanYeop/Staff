package org.example.mobileappproject.data;

import java.io.Serializable;

public class MonthWage implements Serializable {
    int _id;
    String staff_id;
    int wage;
    int time;

    public MonthWage (int _id , String staff_id, int wage, int time){
        this._id = _id;
        this.staff_id = staff_id;
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
