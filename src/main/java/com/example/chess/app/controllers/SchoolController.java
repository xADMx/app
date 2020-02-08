package com.example.chess.app.controllers;

import com.example.chess.app.orm.School;
import com.example.chess.app.repos.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/school/")
public class SchoolController {

    @Autowired
    private SchoolRepo schoolRepo;

    @GetMapping
    public String getSchool(Model model) {
        model.addAttribute("schools", schoolRepo.findAll());
        return "school/list";
    }

    @PostMapping("/add")
    public String addSchool(@Valid School school, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", ControllerUtils.getErrors(bindingResult));
            model.addAttribute("url", "school/add");
            return "error";
        }
        try{
            schoolRepo.save(school);
            return "redirect:/school/";
        } catch (DataIntegrityViolationException ex){
            model.addAttribute("errorMgs","Ошибка добавления: школа с таким названием уже существует.");
            return "error";
        }
    }

    @GetMapping("/add")
    public String addSchool(Model model) {
        return "school/add";
    }

    @GetMapping("/delete/{id}")
    public String deleteSchool(@PathVariable ("id") School school, Model model) {
        try {
            schoolRepo.delete(school);
            return "redirect:/school/";
        } catch (Exception ex){
            model.addAttribute("errorMgs","Ошибка удаления.");
            return "error";
        }
    }

}
