package com.mvc.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

public class User {
    @NotEmpty(message = "用户名不可为空")
    private String name;
    private String email;
    private String gender;
//    @Past(message = "生日不可超过当前日期")
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date birth;

    @NumberFormat(pattern="#,###,###.#")
    private Float salary;

    private List<String> hobbies;

    public User() {
    }

    public User(@NotEmpty(message = "用户名不可为空") String name, String email, String gender, Float salary, List<String> hobbies) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", hobbies=" + hobbies +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
