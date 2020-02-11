package com.example.chess.app.orm;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Поле название школы должно быть заполнено")
    private String nameSchool;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "school")
    private Set<Student> students;

    public School() {
    }

    public School(@NotNull(message = "Поле название школы должно быть заполнено") String nameSchool) {
        this.nameSchool = nameSchool;
    }

    public Integer getId() {
        return id;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(id, school.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
