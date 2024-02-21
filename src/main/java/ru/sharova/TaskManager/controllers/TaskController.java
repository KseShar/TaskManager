package ru.sharova.TaskManager.controllers;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.sharova.TaskManager.DTO.TaskDTO;
import ru.sharova.TaskManager.services.TaskService;
import ru.sharova.TaskManager.models.Task;
import ru.sharova.TaskManager.util.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;
    private final ModelMapper modelMapper;
    @GetMapping("/")
    public List<TaskDTO> getTasks(){
        return service.findAll().stream().map(this::convertToTaskDTO)
        .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable("id") int id){
        return convertToTaskDTO(service.findOne(id));//Jackson конвертирует этот объект в JSON
    }

    @PostMapping("/new")
    public ResponseEntity<> create(@RequestBody TaskDTO taskDTO,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new TaskNotCreatedException(errorMsg.toString());
        }
        service.save(convertToPerson(personDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Task convertToTask(TaskDTO taskDTO){
        Task task = modelMapper.map(taskDTO, Task.class);
        return task;
    }

    private TaskDTO convertToTaskDTO(Task task){
        TaskDTO taskDTO = modelMapper.map(task, TaskDTO.class);
        return taskDTO;
    }

}
