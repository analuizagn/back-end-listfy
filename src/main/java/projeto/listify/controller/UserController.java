package projeto.listify.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.listify.dto.request.UserDto;
import projeto.listify.dto.request.UserUpdateDto;
import projeto.listify.dto.response.UserView;
import projeto.listify.entity.User;
import projeto.listify.service.impl.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserView> saveUser(@RequestBody @Valid UserDto userDto) {
        User savedUser = this.userService.save(userDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserView(savedUser));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserView> findById(@PathVariable Long id) {
        User user = this.userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new UserView(user));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserView> findByEmail(@PathVariable String email) {
        User user = this.userService.findByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(new UserView(user));
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserByEmail(@PathVariable String email) {
        this.userService.deleteUserByEmail(email);
    }

    @PatchMapping
    public ResponseEntity<UserView> updateUser(
            @RequestParam("userId") Long id,
            @RequestBody @Valid UserUpdateDto userUpdateDto
    ) {
        User user = this.userService.findById(id);
        User userToUpdate = userUpdateDto.toEntity(user);
        User userUpdated = this.userService.save(userToUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(new UserView(userUpdated));
    }
}
