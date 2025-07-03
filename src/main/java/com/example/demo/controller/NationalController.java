package com.example.demo.controller;

import com.example.demo.entity.National;
import com.example.demo.service.NationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nationals")
@CrossOrigin(origins = "*") // Cho phép frontend truy cập
public class NationalController {

    @Autowired
    private NationalService nationalService;

    @GetMapping
    public List<National> getAllNationals() {
        return nationalService.getAllNationals();
    }

    @PostMapping
    public National addNational(@RequestBody National national) {
        return nationalService.saveNational(national);
    }

    @DeleteMapping("/{id}")
    public void deleteNational(@PathVariable Integer id) {
        nationalService.deleteNational(id);
    }
}
