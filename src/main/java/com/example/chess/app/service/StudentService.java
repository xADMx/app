package com.example.chess.app.service;

import com.example.chess.app.orm.DTO.RatingTableDTO;
import com.example.chess.app.orm.Student;
import com.example.chess.app.repos.StudentRepo;
import org.my.Monitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    @Cacheable(cacheNames="Rating",cacheManager = "MyCacheManager")
    public RatingTableDTO getRatingStudents(){
        return new RatingTableDTO(LocalDateTime.now(), studentRepo.findTop5ByOrderByRatingAloDesc());
    }

    public List<Student> findAll(){
        return studentRepo.findAll();
    }

    @Monitoring("RandomTestStudents")
    public Pair<Student, Student> getPairRandomStudent(){
        Random random = new Random();
        List<Student> sutends = studentRepo.findAll().stream().sorted((o1, o2) -> random.nextInt(2) - 1).limit(2).collect(Collectors.toList());

        if(sutends.size() > 1){
            return Pair.of(sutends.get(0), sutends.get(1));
        } else {
            return null;
        }
    }

    @Monitoring("SaveChangeStudents")
    public Student save(Student s){
        return studentRepo.save(s);
    }

    public void delete(Student s){
        studentRepo.delete(s);
    }

}
