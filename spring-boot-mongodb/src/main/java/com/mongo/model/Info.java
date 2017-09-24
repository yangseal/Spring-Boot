package com.mongo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
public class Info {
    @Id
    private String id;
    private  String name;
    private  int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
