package ru.kknd.tdboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.kknd.tdboard.models.TaskModel;
import ru.kknd.tdboard.repository.TaskDao;

import java.util.List;

@SpringBootApplication
public class TdBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(TdBoardApplication.class, args);
    }

}
