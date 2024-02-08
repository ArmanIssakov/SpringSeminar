package kz.arman.arman_notes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/executors")
public class ExecutorController {

    private final ExecutorService executorService;

    @GetMapping
    public List<Executor> getAllExecutor() {
        return executorService.findAllExecutor();
    }

    @PostMapping
    public Executor addExecutor(@RequestBody Executor executor) {
        return executorService.addExecutor(executor);
    }

    @GetMapping("/{id}")
    public Executor getExecutor(@PathVariable Long id) {
        return executorService.findExecutorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteExecutor(@PathVariable Long id) {
        executorService.deleteExecutor(id);
    }
}
