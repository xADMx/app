package com.example.chess.app.orm.DTO;

import com.example.chess.app.controllers.ControllerUtils;
import com.example.chess.app.orm.Student;

import java.time.LocalDateTime;
import java.util.List;

public class RatingTableDTO {
    private LocalDateTime localDateTime;
    private List<Student> students;

    public RatingTableDTO(LocalDateTime localDateTime, List<Student> students) {
        this.localDateTime = localDateTime;
        this.students = students;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getLocalDateTimeToString() {
        return ControllerUtils.formatterTime.format(localDateTime);
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
