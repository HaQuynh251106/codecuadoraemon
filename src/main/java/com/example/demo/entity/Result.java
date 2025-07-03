package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "results")

public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tự tăng giá trị id
    private Long id;
    private Double mark;
    private Integer subject_id;
    private Integer student_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }
}
