package com.example.chess.app.orm;

import com.example.chess.app.controllers.ControllerUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Сущность представления учеников.
* {@link NamedQuery} - "randomStudents" - именнованный запрос HQL для получения случайно отсортированных записей.
 */
@NamedQuery(name = "randomStudents", query = "select s FROM Student s ORDER BY RAND()")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Поле ФИО не может быть пустым")
    private String fio;

    @Basic
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Поле дата рождения не может быть пустым.")
    private LocalDate birthday;

    @OneToOne(fetch = FetchType.LAZY)
    @NotNull(message = "Необходимо выбрать школу.")
    private School school;

    private int ratingAlo = 1400;

    public Student() {
    }

    public Student(@NotNull(message = "Поле ФИО не может быть пустым") String fio, @NotNull(message = "Поле дата рождения не может быть пустым.") LocalDate birthday, @NotNull(message = "Необходимо выбрать школу.") School school) {
        this.fio = fio;
        this.birthday = birthday;
        this.school = school;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Integer getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getBirthdayToString(){
        return ControllerUtils.formatter.format(birthday);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getRatingAlo() {
        return ratingAlo;
    }

    public void setRatingAlo(int ratingAlo) {
        this.ratingAlo = ratingAlo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", birthday=" + birthday +
                ", ratingAlo=" + ratingAlo +
                '}';
    }
}
