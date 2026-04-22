package io.bainess.task.service;

import io.bainess.epic.dal.EpicRepository;
import io.bainess.epic.model.Epic;
import io.bainess.exception.NotFoundException;
import io.bainess.task.dal.TaskRepository;
import io.bainess.task.dto.NewTaskRequest;
import io.bainess.task.dto.TaskMinimalDto;
import io.bainess.task.mapper.TaskMapper;
import io.bainess.task.model.Task;
import io.bainess.user.dal.UserRepository;
import io.bainess.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;
    private EpicRepository epicRepository;

    public TaskMinimalDto createTask(NewTaskRequest request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User " + userId + " was not found"));
        Epic epic = null;
        if (request.getEpicId() != null) {
            epic = epicRepository.findById(request.getEpicId())
                    .orElseThrow(() -> new NotFoundException("Epic " + request.getEpicId() + " was not found"));
        }

        Task task = TaskMapper.mapToTask(request);
        task.setAuthor(user);
        task.setEpic(epic);
        taskRepository.save(task);

        return TaskMapper.mapToTaskMinimalDto(task);
            }
}
