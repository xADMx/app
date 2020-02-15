package com.example.chess.app.validation;

import com.example.chess.app.orm.School;
import com.example.chess.app.orm.Student;
import com.example.chess.app.repos.SchoolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Владитор сущности школа для проверки на уникальность поля nameSchool в БД.
 */
@Service
public class SchoolValidation implements Validator {

    @Autowired
    private SchoolRepo schoolRepo;

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        School school = (School) target;
        if (schoolRepo.countByNameSchool(school.getNameSchool()) > 0) {
            errors.rejectValue("nameSchool", "nameSchool.taken", "Школа с таким название уже существует.");
        }
    }
}
