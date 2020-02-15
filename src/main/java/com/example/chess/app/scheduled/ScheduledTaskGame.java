package com.example.chess.app.scheduled;

import com.example.chess.app.controllers.ControllerUtils;
import com.example.chess.app.orm.Student;
import com.example.chess.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScheduledTaskGame {

    @Autowired
    private StudentService studentService;

    @Scheduled(fixedRate = 30000)
    public void game(){
        Pair<Student, Student> pairRandomStudent = studentService.getPairRandomStudent();
        if(pairRandomStudent != null) {
            Random random = new Random();
            random.nextInt(100);

            double eaFirst = this.getEa(pairRandomStudent.getFirst(), pairRandomStudent.getSecond());
            double eaSecond = this.getEa(pairRandomStudent.getSecond(), pairRandomStudent.getFirst());
            int ratingAloFirst;
            int ratingAloSecond;

            if (random.nextInt(100) > 50) {
                ratingAloFirst = this.getRatingAlo(pairRandomStudent.getFirst().getRatingAlo(), eaFirst, 1);
                ratingAloSecond = this.getRatingAlo(pairRandomStudent.getSecond().getRatingAlo(), eaSecond, 0);
            } else {
                ratingAloFirst = this.getRatingAlo(pairRandomStudent.getFirst().getRatingAlo(), eaFirst, 0);
                ratingAloSecond = this.getRatingAlo(pairRandomStudent.getSecond().getRatingAlo(), eaSecond, 1);
            }

            pairRandomStudent.getSecond().setRatingAlo(ratingAloSecond);
            pairRandomStudent.getFirst().setRatingAlo(ratingAloFirst);


            studentService.save(pairRandomStudent.getFirst());
            studentService.save(pairRandomStudent.getSecond());
        }

    }

    private int getRatingAlo(int ratinfAloStudent, double ea, double countPoint){
        return (int) (ratinfAloStudent + 16 * (countPoint - ea));
    }

    private double getEa(Student student1, Student student2){
        return 1 / (1 + Math.pow(10, ((student1.getRatingAlo() - student2.getRatingAlo()) / 400)));
    }

}
