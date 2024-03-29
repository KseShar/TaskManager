package ru.sharova.TaskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sharova.TaskManager.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
