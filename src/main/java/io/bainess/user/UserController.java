package io.bainess.user;

import io.bainess.user.dto.NewUserRequest;
import io.bainess.user.dto.UserDto;
import io.bainess.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody NewUserRequest request) {
        return userService.saveUser(request);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUser(@PathVariable(name = "userId") Long userId) {
        return userService.getUser(userId);
    }
}
