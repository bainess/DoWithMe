package io.bainess.user.service;

import io.bainess.user.dto.NewUserRequest;
import io.bainess.user.dto.UserDto;
import io.bainess.user.mapper.UserMapper;
import io.bainess.user.model.User;
import io.bainess.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public UserDto saveUser(NewUserRequest request) {
        User user = UserMapper.mapToUser(request);
        userRepository.save(user);
        return UserMapper.mapToUserDto(user);
    }
}
