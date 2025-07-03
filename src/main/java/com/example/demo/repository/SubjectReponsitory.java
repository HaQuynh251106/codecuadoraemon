package com.example.demo.repository;

import com.example.demo.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectReponsitory extends JpaRepository<Subject,Long>{
}
