package ru.sharova.TaskManager.DTO;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sharova.TaskManager.enums.Priority;
import ru.sharova.TaskManager.enums.Status;
@Data
@RequiredArgsConstructor
public class TaskDTO {
    private String title;
    private String description;
    private Status statusID;
    private Priority priorityID;
}
