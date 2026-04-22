package io.bainess.task;

import io.bainess.task.dto.NewTaskRequest;
import io.bainess.task.dto.TaskMinimalDto;
import io.bainess.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskMinimalDto createTask(@RequestHeader("X-Do-With-Me-User-Id") Long userId,
                                     @RequestBody NewTaskRequest request) {
        return taskService.createTask(request, userId);
    }
}
