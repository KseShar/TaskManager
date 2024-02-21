package ru.sharova.TaskManager.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sharova.TaskManager.DTO.TaskDTO;
import ru.sharova.TaskManager.util.TaskNotFoundException;
import ru.sharova.TaskManager.models.Task;
import ru.sharova.TaskManager.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TaskService {
    @Autowired
    private final TaskRepository repository;

    public List<Task> findAll() {
        return repository.findAll();
    }
    public Task findOne(int id) {
        Optional<Task> foundTask = repository.findById(id);
        return foundTask.orElseThrow(TaskNotFoundException::new);
    }
}
