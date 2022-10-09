package ru.kknd.tdboard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kknd.tdboard.models.TaskModel;
import ru.kknd.tdboard.repository.TaskDao;
import ru.kknd.tdboard.services.TaskService;

import java.time.LocalDate;

@Controller
public class TaskController {

    private TaskService service;
    private TaskModel mod;

    public TaskController(TaskService service, TaskModel mod) {
        this.service = service;
        this.mod = mod;
    }

    @GetMapping("/daily")
    public String getDailyPage(Model model) {
        model.addAttribute("tasks", service.getTasksOnDay());
        return "daily";
    }

    @PostMapping("/daily")
    public String setNewTask(@RequestParam String description,
                             @RequestParam String deadline) {
        service.insertTask(description, LocalDate.parse(deadline));
        return "daily";
    }
    @PutMapping("/daily")
    public String doneTask(@RequestParam int id) {
        service.doneTaskById(id);
        return "daily";
    }

    @GetMapping("/week")
    public String getWeekPage(Model model) {
        return "week";
    }

    @PostMapping("/week")
    public String setNewTaskW(@RequestParam String description,
                             @RequestParam String deadline) {
        service.insertTask(description, LocalDate.parse(deadline));
        return "week";
    }

    @GetMapping("/month")
    public String getMonthPage(Model model) {
        return "month";
    }

    @PostMapping("/month")
    public String setNewTaskM(@RequestParam String description,
                             @RequestParam String deadline) {
        service.insertTask(description, LocalDate.parse(deadline));
        return "month";
    }

    @GetMapping("/year")
    public String getYearPage(Model model) {
        return "year";
    }

    @PostMapping("/year")
    public String setNewTaskY(@RequestParam String description,
                             @RequestParam String deadline) {
        service.insertTask(description, LocalDate.parse(deadline));
        return "year";
    }
}
