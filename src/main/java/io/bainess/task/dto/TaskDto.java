package io.bainess.task.dto;

import io.bainess.task.model.Status;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String text;
    private LocalDateTime createdAt;
    private Status status;
    private Long epicId;
    private String taskCreatorName;
    private String assignedToName;
}
