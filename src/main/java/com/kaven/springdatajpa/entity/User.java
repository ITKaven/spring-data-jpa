package com.kaven.springdatajpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @program: spring-data-jpa
 * @description: 用户类
 * @author: Kaven
 * @create: 2018-11-16 12:50
 **/
@Entity(name = "user")
public class User {

    //用户唯一标识
    @Id
    @GeneratedValue
    private Integer id;

    //用户年龄
    private Integer age;

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{\n" +
                "      id: " + id +",\n"+
                "      age: " + age +
                "\n}";
    }
}