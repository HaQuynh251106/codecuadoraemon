package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GuestController {
    @GetMapping()
    public String home(Model model){
        model.addAttribute("content", "home");
        model.addAttribute("title", "Trang chủ");
        return "layout/guest";
    }
}
