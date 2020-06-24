package pro.claudiogomes.tasks;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TasksRepository {

  private DataSource dataSource;

  public TasksRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Task createTask(Task task) {

    Connection connection = DataSourceUtils.getConnection(dataSource);

    try {
      String sqlTemplate = "INSERT INTO tasks (title, completed) VALUES (?, ?);";
      PreparedStatement ps =
          connection.prepareStatement(sqlTemplate, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, task.getTitle());
      ps.setBoolean(2, task.isCompleted());
      int rowsAffected = ps.executeUpdate();

      if (rowsAffected == 1) {
        ResultSet result = ps.getGeneratedKeys();
        result.next();
        int id = result.getInt(1);
        return new Task(id, task.getTitle(), task.isCompleted());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DataSourceUtils.releaseConnection(connection, dataSource);
    }

    return null;
  }

  public List<Task> readTasks() {

    Connection connection = DataSourceUtils.getConnection(dataSource);

    ArrayList<Task> tasks = new ArrayList<Task>();

    try {
      String sql = "SELECT * FROM tasks;";
      PreparedStatement ps = connection.prepareStatement(sql);
      ResultSet rowPointer = ps.executeQuery();

      while (rowPointer.next()) {
        Task task =
            new Task(rowPointer.getInt(1), rowPointer.getString(2), rowPointer.getBoolean(3));
        tasks.add(task);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DataSourceUtils.releaseConnection(connection, dataSource);
    }

    return tasks;
  }

  public Task updateTask(int id, Task task) {

    Connection connection = DataSourceUtils.getConnection(dataSource);

    try {
      String sql = "UPDATE tasks SET completed=? WHERE id=?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setBoolean(1, task.isCompleted());
      ps.setInt(2, id);
      int rowsAffected = ps.executeUpdate();

      if (rowsAffected == 1) {
        return task;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DataSourceUtils.releaseConnection(connection, dataSource);
    }

    return null;
  }

  public void deleteTask(int id) {
    Connection connection = DataSourceUtils.getConnection(dataSource);

    try {
      String sql = "DELETE FROM tasks WHERE id=?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DataSourceUtils.releaseConnection(connection, dataSource);
    }
  }
}
