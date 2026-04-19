package io.bainess.user.service;

import io.bainess.exception.NotFoundException;
import io.bainess.user.dto.NewUserRequest;
import io.bainess.user.dto.UserDto;
import io.bainess.user.mapper.UserMapper;
import io.bainess.user.model.User;
import io.bainess.user.dal.UserRepository;
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

    public UserDto getUser(Long id) {
        User user =  userRepository.findById(id).orElseThrow(() -> new NotFoundException("User with id " + id + " was not found"));
        return UserMapper.mapToUserDto(user);
    }
}
