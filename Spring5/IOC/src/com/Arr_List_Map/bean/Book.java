package com.Arr_List_Map.bean;

import java.util.List;

public class Book {
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Book{" +
                "list=" + list +
                '}';
    }

    public void info(){
        System.out.println(toString());
    }
}
