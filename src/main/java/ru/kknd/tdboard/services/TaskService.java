package ru.kknd.tdboard.services;
import org.springframework.stereotype.Service;
import ru.kknd.tdboard.models.TaskModel;
import ru.kknd.tdboard.repository.TaskDao;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskDao dao;

    public TaskService(TaskDao dao) {
        this.dao = dao;
    }

    public List<TaskModel> getAllTasks () {
        return dao.getAllTasks();
    }

    public void insertTask (String descr, LocalDate dl) {
        dao.insertTask(descr, dl);
    }

    public void doneTaskById(int id) {
        dao.doneTaskById(id);
    }
}
