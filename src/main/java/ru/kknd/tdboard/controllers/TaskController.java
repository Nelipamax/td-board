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

    @PostMapping("/add-task")
    public String addNewTask(@RequestParam String description,
                             @RequestParam String deadline) {
        service.insertTask(description, LocalDate.parse(deadline));
        return "redirect:/daily";
    }

    @PostMapping("/done-task")
    public String doneTask(@RequestParam int id) {
        service.doneTaskById(id);
        return "redirect:/daily";
    }
}
