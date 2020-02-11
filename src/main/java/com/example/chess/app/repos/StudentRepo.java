package com.example.chess.app.repos;

import com.example.chess.app.orm.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import java.util.List;


public interface StudentRepo extends CrudRepository<Student, Integer>, JpaRepository<Student, Integer> {

    List<Student> findTop5ByOrderByRatingAloDesc();


}
