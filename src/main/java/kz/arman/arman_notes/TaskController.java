package kz.arman.arman_notes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<Task> findAll() {
        return taskService.findAllTask();
    }

    @GetMapping("/{status}")
    public List<Task> findByTaskStatus(@PathVariable String status) {
        return taskService.findByTaskStatus(status);
    }

    @PutMapping("/{id}/{status}")
    public void updateTaskStatus(@PathVariable Long id, @PathVariable String status) {
        taskService.updateTaskStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
       return taskService.addTask(task);
    }

    @PutMapping("/{id}/executor/{executorId}")
    public Task assignExecutorToTask(@PathVariable Long id, @PathVariable Long executorId) {
        return taskService.assignExecutor(id, executorId);
    }

}
