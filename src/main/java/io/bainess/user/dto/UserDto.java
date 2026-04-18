package io.bainess.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Builder
@Getter
public class UserDto {
    private Long id;
    private String nickname;
}
