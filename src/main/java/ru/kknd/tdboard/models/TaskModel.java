package ru.kknd.tdboard.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
@Data
public class TaskModel {
    private int id;
    private LocalDate dateOfCreation;
    private LocalDate deadline;
    private String description;
    private boolean status;


    @Override
    public String toString() {
        return "Задача: " + description + " Выполнить до: " + deadline;
    }
}
