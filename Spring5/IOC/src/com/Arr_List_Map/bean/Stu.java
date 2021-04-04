package com.Arr_List_Map.bean;


import java.util.*;

public class Stu {
    private String[] courses;
    private List<String> list;
    private Map<String,String> maps;
    private Set<String> sets;

    private List<Course> listCourse;

    public List<Course> getListCourse() {
        return listCourse;
    }

    public void setListCourse(List<Course> listCourse) {
        this.listCourse = listCourse;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }


    @Override
    public String toString() {
        return "Stu{" +
                "courses=" + Arrays.toString(courses) +
                ",\nlist=" + list +
                ", \nmaps=" + maps +
                ", \nsets=" + sets +
                ", \nlistCourse=" + listCourse.toString() +
                '}';
    }

    public void info(){
        System.out.println(toString());
    }
}
