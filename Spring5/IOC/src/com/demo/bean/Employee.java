package com.demo.bean;

public class Employee {
    private String eName;
    private String eGender;
    //员工属于某一个部门，使用对象形式表示
    private Department department;


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteGender() {
        return eGender;
    }

    public void seteGender(String eGender) {
        this.eGender = eGender;
    }

    public void info(){
        System.out.println("name:"+eName+",gender:"+eGender+",Dep:"+department.getdName());
    }
    @Override
    public String toString() {
        return "Employee{" +
                "eName='" + eName + '\'' +
                ", eGender='" + eGender + '\'' +
                ", department=" + department.getdName() +
                '}';
    }
}
