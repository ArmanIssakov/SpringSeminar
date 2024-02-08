package kz.arman.arman_notes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class ExecutorService {

    private final ExecutorRepository executorRepository;

    public Executor addExecutor(Executor executor) {
        return executorRepository.save(executor);
    }

    public List<Executor> findAllExecutor() {
        return executorRepository.findAll();
    }

    public Executor findExecutorById(Long id) {
        return executorRepository.findById(id).get();
    }

    public void deleteExecutor(Long id) {
        executorRepository.deleteById(id);
    }
}
