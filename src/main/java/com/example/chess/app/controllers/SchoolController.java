package com.example.chess.app.controllers;

import com.example.chess.app.orm.School;
import com.example.chess.app.repos.SchoolRepo;
import com.example.chess.app.service.SchoolService;
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

/**
 * Контроллер школы
 */
@Controller
@RequestMapping(path = "/school/")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    /**
     * Метод вывода списка школ
     * @param model
     * @return
     */
    @GetMapping
    public String getSchool(Model model) {
        model.addAttribute("schools", schoolService.findAll());
        return "school/list";
    }

    /**
     * Метод добавления школы
     * @param school
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping("/add")
    public String addSchool(@Valid School school, BindingResult bindingResult, Model model) {

        school = schoolService.save(school, bindingResult);

        if(school == null){
            model.addAttribute("errors", ControllerUtils.getErrors(bindingResult));
            model.addAttribute("url", "/school/add");
            return "myError";
        }

        return "redirect:/school/";
    }

    /**
     * Метод вывода формы для добавления школы.
     * @param model
     * @return
     */
    @GetMapping("/add")
    public String addSchool(Model model) {
        return "school/add";
    }

    /**
     * Метод удаления школы.
     * @param school
     * @param model
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteSchool(@PathVariable ("id") School school, Model model) {
        try {
            schoolService.delete(school);
            return "redirect:/school/";
        } catch (Exception ex){
            model.addAttribute("errorMgs","Ошибка удаления.");
            return "myError";
        }
    }

}
