package org.nuzhd.vktesttask.controller;

import lombok.RequiredArgsConstructor;
import org.nuzhd.vktesttask.dto.post.PostCreateRequest;
import org.nuzhd.vktesttask.dto.post.PostPatchRequest;
import org.nuzhd.vktesttask.dto.post.PostUpdateRequest;
import org.nuzhd.vktesttask.dto.user.UserCreateRequest;
import org.nuzhd.vktesttask.dto.user.UserPatchRequest;
import org.nuzhd.vktesttask.dto.user.UserUpdateRequest;
import org.nuzhd.vktesttask.entity.Post;
import org.nuzhd.vktesttask.entity.User;
import org.nuzhd.vktesttask.service.PostService;
import org.nuzhd.vktesttask.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        return ResponseEntity
                .ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
        User user = userService.getUserById(userId);

        return ResponseEntity
                .ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserCreateRequest userCreateRequest) {
        User createdUser = userService.createUser(userCreateRequest);

        return ResponseEntity
                .ok(createdUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        User updatedUser = userService.updateUser(userId, userUpdateRequest);

        return ResponseEntity
                .ok(updatedUser);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<User> patchUser(@PathVariable("userId") Long userId, @RequestBody UserPatchRequest userPatchRequest) {
        User patchedUser = userService.patchUser(userId, userPatchRequest);

        return ResponseEntity
                .ok(patchedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {

        return ResponseEntity
                .noContent()
                .build();
    }
}
