package io.bainess.task.dto;

import io.bainess.task.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class NewTaskRequest {
    private String text;
    private Status status = Status.NEW;
    private Long taskCreatorId;
    private Long epicId;
}
