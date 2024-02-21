package ru.sharova.TaskManager.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sharova.TaskManager.enums.Priority;
import ru.sharova.TaskManager.enums.Status;

@Entity
@Data
@RequiredArgsConstructor
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;
    /* @NotEmpty(message = "Name should not be empty")
     @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")*/
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "status_id")
    private Status statusID;
    @Column(name = "priority_id")
    private Priority priorityID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Person author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "executor_id", referencedColumnName = "id")
    private Person executor;
}
