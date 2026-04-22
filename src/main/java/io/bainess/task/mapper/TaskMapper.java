package io.bainess.task.mapper;

import io.bainess.epic.model.Epic;
import io.bainess.task.dto.NewTaskRequest;
import io.bainess.task.dto.TaskMinimalDto;
import io.bainess.task.model.Task;
import io.bainess.user.model.User;

public class TaskMapper {

    public static Task mapToTask(NewTaskRequest request) {
        return Task.builder()
                .text(request.getText())
                .status(request.getStatus())
                .build();
    }

    public static TaskMinimalDto mapToTaskMinimalDto(Task task) {
        return TaskMinimalDto.builder()
                .id(task.getId())
                .text(task.getText())
                .build();
    }
}
