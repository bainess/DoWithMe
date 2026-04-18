package io.bainess.user.mapper;

import io.bainess.user.dto.NewUserRequest;
import io.bainess.user.dto.UserDto;
import io.bainess.user.model.User;

public class UserMapper {
    public static User mapToUser(NewUserRequest request) {
        return User.builder().nickname(request.getNickname()).build();
    }

    public static UserDto mapToUserDto(User user) {
        return UserDto.builder().id(user.getId()).nickname(user.getNickname()).build();
    }
}
