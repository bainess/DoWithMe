package io.bainess.user.service;

import io.bainess.user.dto.NewUserRequest;
import io.bainess.user.dto.UserDto;

public interface UserService {

    UserDto saveUser(NewUserRequest request);
}
