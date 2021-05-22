package org.example.mobileappproject.data;

import java.io.Serializable;

public class Staff implements Serializable {
    int _id;
    String staff_id;
    int wage;

    public Staff(int _id,String staff_id, int wage){
        this._id = _id;
        this.staff_id = staff_id;
        this.wage = wage;
    }

    public Staff(String staff_id, int wage){
        this.staff_id = staff_id;
        this.wage = wage;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int get_id() {
        return _id;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public int getWage() {
        return wage;
    }
}
