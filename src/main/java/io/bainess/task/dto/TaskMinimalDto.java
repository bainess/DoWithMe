package io.bainess.task.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskMinimalDto {
    private Long id;
    private String text;
}
