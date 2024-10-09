package com.example.firstProject.model;

import lombok.Data;

@Data
public class StudentModel {
    public String name;
    public int age;
    public int prn;
    public StudentModel(String name, int age,int prn) {
        this.name = name;
        this.prn = prn;
        this.age = age;
    }

}
