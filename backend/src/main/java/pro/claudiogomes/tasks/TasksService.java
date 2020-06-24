package pro.claudiogomes.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

  @Autowired private TasksRepository repository;

  public Task createTask(String title, boolean completed) {
    return this.repository.createTask(new Task(title, completed));
  }

  public List<Task> readTasks() {
    return this.repository.readTasks();
  }

  public Task updateTask(int id, Task task) {
    return this.repository.updateTask(id, task);
  }

  public void deleteTask(int id) {
    this.repository.deleteTask(id);
  }
}
