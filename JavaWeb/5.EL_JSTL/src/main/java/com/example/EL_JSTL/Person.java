package com.example.EL_JSTL;

import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private String Tel;
    private List<String> city;
    private Map<String,Object> map;

    public Person() {
    }

    public Person(String name, String tel, List<String> city, Map<String, Object> map) {
        this.name = name;
        Tel = tel;
        this.city = city;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", Tel='" + Tel + '\'' +
                ", city=" + city +
                ", map=" + map +
                '}';
    }
}
