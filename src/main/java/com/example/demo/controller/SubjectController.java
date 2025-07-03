package com.example.demo.controller;

import com.example.demo.entity.Subject;
import com.example.demo.repository.SubjectReponsitory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/subjects")

public class SubjectController {
    private SubjectReponsitory subjectReponsitory;

    public SubjectController(SubjectReponsitory subjectReponsitory){
        this.subjectReponsitory = subjectReponsitory;
    }

    @GetMapping()
    public String getAllSubject(Model model){
        List<Subject> list = subjectReponsitory.findAll();
        model.addAttribute("subjects", list);
        model.addAttribute("content", "subjects/list");
        return "layout/main";
    }

    @GetMapping("create")
    public String formCreate(Model model){
        model.addAttribute("content", "subjects/create_form");
        return "layout/main";
    }

    @PostMapping("create")
    public String createStudent(@ModelAttribute Subject subject){
        subjectReponsitory.save(subject);
        return "redirect:/subjects";
    }

    @GetMapping("edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        Subject s = subjectReponsitory.findById(id).orElseThrow();
        model.addAttribute("Subject", s);
        model.addAttribute("content", "subjects/edit_form");
        return "layout/main";
    }

    @PostMapping("edit")
    public String updateStudent(@ModelAttribute Subject subject){
        subjectReponsitory.save(subject);
        return "redirect:/subjects";
    }

    @GetMapping("delete/{id}")
    public  String deleteStudent(@PathVariable Long id){
        Subject s = subjectReponsitory.findById(id).orElseThrow();
        subjectReponsitory.delete(s);
        return "redirect:/subjects";
    }
}
