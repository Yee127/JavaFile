package com.example.JsonTest;

import com.example.Bean.Person;
import com.example.Bean.PersonListType;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1 {
    @Test
    public void BeanToJson(){
        Person person = new Person("mike",22);
        Gson gson = new Gson();
        // toJson 方法可以把 java 对象转换成为 json 字符串
        System.out.println("—————————————javaBean 转 Json ———————————————");
        String json = gson.toJson(person);
        System.out.println(json);

        System.out.println("——————————————Json 转 javaBean————————————————");
        // fromJson 把 json 字符串转换回 Java 对象
        Person person1 = gson.fromJson(json, Person.class);
        System.out.println(person1);

    }
    @Test
    public void ListAndJson(){
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("滴滴",1));
        list.add(new Person("哈哈",2));

        Gson gson = new Gson();
        System.out.println("—————————————List 转 Json ———————————————");
        String json = gson.toJson(list);
        System.out.println(json);
        System.out.println("—————————————Json 转 List ———————————————");
        List<Person> personList = gson.fromJson(json,new PersonListType().getType());
        System.out.println(personList);

    }
    @Test
    public void MapAndJson(){
        Map<Integer,Person> personMap = new HashMap<Integer,Person>();
        personMap.put(1,new Person("tom",9));
        personMap.put(2,new Person("lucy",19));

        Gson gson = new Gson();
        System.out.println("—————————————Map 转 Json ———————————————");
        String json = gson.toJson(personMap);
        System.out.println(json);
        System.out.println("—————————————Json 转 Map ———————————————");
        Map<Integer,Person> personMap2 = gson.fromJson(json, new TypeToken<HashMap<Integer, Person>>() {
        }.getType());
        System.out.println(personMap2);

        System.out.println(personMap2.get(1));
    }
}
