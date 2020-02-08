package com.example.chess.app.controllers;

import com.example.chess.app.orm.Student;
import com.example.chess.app.repos.SchoolRepo;
import com.example.chess.app.repos.StudentRepo;
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
@RequestMapping(path = "/student/")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SchoolRepo schoolRepo;

    @GetMapping
    public String getStudent(Model model) {
        model.addAttribute("students", studentRepo.findAll());
        return "student/list";
    }

    @PostMapping("/add")
    public String addStudent(@Valid Student student, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", ControllerUtils.getErrors(bindingResult));
            model.addAttribute("url", "student/add");
            return "error";
        }
        try{
            studentRepo.save(student);
            return "redirect:/student/";
        } catch (DataIntegrityViolationException ex){
            model.addAttribute("errorMgs","Ошибка добавления: школа с таким названием уже существует.");
            return "error";
        }
    }

    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("schools", schoolRepo.findAll());
        return "student/add";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable ("id") Student student, Model model) {
        try {
            studentRepo.delete(student);
            return "redirect:/student/";
        } catch (Exception ex){
            model.addAttribute("errorMgs","Ошибка удаления.");
            return "error";
        }
    }

}
