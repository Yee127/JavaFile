package com.Arr_List_Map.bean;

public class Course {
    private String CName;

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "CName='" + CName + '\'' +
                '}';
    }
}
