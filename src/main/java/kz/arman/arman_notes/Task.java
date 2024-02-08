package kz.arman.arman_notes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    private String taskTitle;
    @Column(nullable = false)
    private String taskDescription;
    private String taskStatus;
    private LocalDateTime taskCreationTime;
    @OneToMany
    @JoinColumn(name = "executor_id")
    private List<Executor> executors;

    public Task(String taskTitle, String taskDescription, String taskStatus) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }
}
