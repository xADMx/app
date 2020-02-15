package com.example.chess.app.repos;

import com.example.chess.app.orm.School;
import org.springframework.data.repository.CrudRepository;

public interface SchoolRepo extends CrudRepository<School, Integer> {

    Long countByNameSchool(String nameSchool);

}
