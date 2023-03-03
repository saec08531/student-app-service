package com.sara.student.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int age;
    private String address;
    private String email;
}
