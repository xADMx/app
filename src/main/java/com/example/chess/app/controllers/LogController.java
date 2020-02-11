package com.example.chess.app.controllers;

import org.my.repo.LogClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log/")
public class LogController {

    @Autowired
    private LogClassRepo logClassRepo;

    @GetMapping
    public String getLog(Model model){
        model.addAttribute("logs", logClassRepo.findAll());
        return "log/list";
    }

}
