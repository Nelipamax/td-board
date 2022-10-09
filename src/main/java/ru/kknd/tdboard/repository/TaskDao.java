package ru.kknd.tdboard.repository;

import org.springframework.stereotype.Component;
import ru.kknd.tdboard.models.TaskModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDao {

    private static final String sqlInsert = "INSERT INTO task (description, dateofcreation, deadline, status) VALUES (?,?,?,?)";

    public List<TaskModel> getAllTasks() {
        List<TaskModel> allTasks = new ArrayList<>();
        try {
            Statement statement = DBconn.getConnection().createStatement();
            String SQL = "select * from task where status = false;";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                TaskModel task = new TaskModel();
                task.setId(resultSet.getInt("id"));
                task.setDateOfCreation(resultSet.getDate("dateofcreation").toLocalDate());
                task.setDescription(resultSet.getString("description"));
                task.setDeadline(resultSet.getDate("deadline").toLocalDate());
                task.setStatus(resultSet.getBoolean("status"));
                allTasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allTasks;
    }

    public void insertTask(String descr, LocalDate dl) {
        try {
            PreparedStatement preparedStatement = DBconn.getConnection().prepareStatement(sqlInsert);
            preparedStatement.setString(1, descr);
            preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));
            preparedStatement.setDate(3, Date.valueOf(dl));
            preparedStatement.setBoolean(4, false);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doneTaskById(int id) {
        try {
            PreparedStatement preparedStatement = DBconn.getConnection().prepareStatement("delete from task where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
