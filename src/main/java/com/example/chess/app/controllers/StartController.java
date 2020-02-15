package com.example.chess.app.controllers;

import com.example.chess.app.orm.School;
import com.example.chess.app.orm.Student;
import com.example.chess.app.repos.SchoolRepo;
import com.example.chess.app.repos.StudentRepo;
import com.example.chess.app.service.SchoolService;
import com.example.chess.app.service.StudentService;
import org.my.Monitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/start/test/")
public class StartController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolService schoolService;

    @Monitoring("LoadDATATest")
    @GetMapping
    public String getSchool(Model model) {
        School one = new School("Первая");
        School two = new School("Вторая");
        School three = new School("Третья");

        BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(one, "nameSchool");
        one = schoolService.save(new School("Первая"), bindingResult);
        two = schoolService.save(new School("Вторая"), bindingResult);
        three = schoolService.save(new School("Третья"), bindingResult);


        if(!bindingResult.hasErrors()) {
            Student studentKozlo = new Student("Козло Александр", LocalDate.of(1991, 05, 30), one);
            Student studentEremeev = new Student("Еремеев Николай", LocalDate.of(1992, 06, 25), one);
            Student studentEgorov = new Student("Егоров Александр", LocalDate.of(1991, 05, 12), two);
            Student studentNikanorov = new Student("Никаноров Андрей", LocalDate.of(1993, 02, 10), two);
            Student studentVolkov = new Student("Волков Дмитрий", LocalDate.of(1991, 05, 12), three);
            Student studentZyeva = new Student("Зуева Татьяна Андрей", LocalDate.of(1993, 02, 10), three);

            studentService.save(studentEgorov);
            studentService.save(studentEremeev);
            studentService.save(studentKozlo);
            studentService.save(studentNikanorov);
            studentService.save(studentVolkov);
            studentService.save(studentZyeva);
        }

        return "redirect:/school/";
    }

}
