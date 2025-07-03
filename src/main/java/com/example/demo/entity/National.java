package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "national")
public class National {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nationalId;

    @Column(nullable = false)
    private String nationalName;

    // Constructors
    public National() {}

    public National(String nationalName) {
        this.nationalName = nationalName;
    }

    // Getters and Setters
    public Integer getNationalId() {
        return nationalId;
    }

    public void setNationalId(Integer nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }
}
