package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự tăng giá trị id
    private Long id;
    private String name;
    private Integer hours;
    private Double cost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}