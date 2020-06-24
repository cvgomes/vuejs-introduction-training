package pro.claudiogomes.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Task>> readTasks() {
        List<Task> tasks = tasksService.readTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Task> createTodo(@RequestBody Task data) {
        Task saved = tasksService.createTask(data.getTitle(), false);
        if(saved == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Task> updateTodo(@PathVariable Integer id, @RequestBody Task task) {
        Task updated = tasksService.updateTask(id, task);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Integer> deleteTodo(@PathVariable Integer id) {
        tasksService.deleteTask(id);
        return ResponseEntity.ok(id);
    }
}
