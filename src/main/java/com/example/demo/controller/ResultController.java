package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.repository.ResultReponsitory;
import com.example.demo.repository.StudentReponsitory;
import com.example.demo.repository.SubjectReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/results")

public class ResultController {

    private StudentReponsitory studentReponsitory;
    private SubjectReponsitory subjectReponsitory;
    private ResultReponsitory resultReponsitory;

    public ResultController(StudentReponsitory studentRepository,
                            SubjectReponsitory subjectRepository,
                            ResultReponsitory resultRepository) {
        this.studentReponsitory = studentRepository;
        this.subjectReponsitory = subjectRepository;
        this.resultReponsitory = resultRepository;
    }

    @GetMapping()
    public String getAllResult(Model model){
        List<Result> list = resultReponsitory.findAll();
        model.addAttribute("results", list);
        model.addAttribute("content", "results/list");
        return "layout/main";
    }

    @GetMapping("create")
    public String formCreate(Model model){
        List<Subject> l = subjectReponsitory.findAll();
        List<Student> list = studentReponsitory.findAll();
        model.addAttribute("subjects", l);
        model.addAttribute("students", list);
        model.addAttribute("content", "results/create_form");
        return "layout/main";
    }

    @PostMapping("create")
    public String createResult(@ModelAttribute Result result){
        resultReponsitory.save(result);
        return "redirect:/results";
    }

    @PostMapping("edit")
    public String updateStudent(@ModelAttribute Result result){
        resultReponsitory.save(result);
        return "redirect:/results";
    }

    @GetMapping("edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        Result s = resultReponsitory.findById(id).orElseThrow();
        model.addAttribute("Result", s);
        model.addAttribute("content", "results/edit_form");
        return "layout/main";
    }

    @GetMapping("delete/{id}")
    public  String deleteStudent(@PathVariable Long id){
        Result s = resultReponsitory.findById(id).orElseThrow();
        resultReponsitory.delete(s);
        return "redirect:/results";
    }
}
