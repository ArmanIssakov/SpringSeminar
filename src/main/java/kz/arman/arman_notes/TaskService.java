package kz.arman.arman_notes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor //Lombok создает конструктор со всеми необходимыми полями
                         // необходимые поля - поля, которые не возможно задать после создания сущности(final)
public class TaskService {

    private final TaskRepository taskRepository;
    private final ExecutorService executorService;

    public Task addTask(Task task) {
        task.setTaskCreationTime(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    public List<Task> findByTaskStatus(String taskStatus) {
        return taskRepository.findAllByTaskStatus(taskStatus);
    }

    public void updateTaskStatus(Long id, String taskStatus) {
        Task updateTask = taskRepository.findById(id).get();
        updateTask.setTaskStatus(taskStatus);
        taskRepository.save(updateTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task assignExecutor(Long taskId, Long executorId) {
        Task existingTask = taskRepository.findById(taskId).get();
        Executor executor = executorService.findExecutorById(executorId);
        List<Executor> bufList = existingTask.getExecutors();
        bufList.add(executor);
        existingTask.setExecutors(bufList);
        return taskRepository.save(existingTask);
    }
}
