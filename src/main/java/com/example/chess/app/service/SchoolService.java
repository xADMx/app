package com.example.chess.app.service;

import com.example.chess.app.orm.School;
import com.example.chess.app.repos.SchoolRepo;
import com.example.chess.app.validation.SchoolValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

/**
 * Сервис по работе с сущностью школа
 */
@Service
public class SchoolService {
    @Autowired
    private SchoolRepo schoolRepo;

    @Autowired
    private SchoolValidation schoolValidation;

    /**
     * Метод для сохранения сущности школы с доп. проверкой {@link SchoolValidation}
     * @param school
     * @param bindingResult
     * @return
     */
    public School save(School school, BindingResult bindingResult){
        schoolValidation.validate(school, bindingResult);
        if(!bindingResult.hasErrors()) {
            return save(school);
        } else {
            return null;
        }
    }

    public School save(School school){
        return schoolRepo.save(school);
    }

    public Iterable<School> findAll(){
        return schoolRepo.findAll();
    }

    public void delete(School school){
        schoolRepo.delete(school);
    }
}
