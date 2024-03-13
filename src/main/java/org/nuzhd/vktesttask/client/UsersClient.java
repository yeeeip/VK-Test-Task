package org.nuzhd.vktesttask.client;

import org.nuzhd.vktesttask.dto.user.UserCreateRequest;
import org.nuzhd.vktesttask.dto.user.UserPatchRequest;
import org.nuzhd.vktesttask.dto.user.UserUpdateRequest;
import org.nuzhd.vktesttask.entity.Album;
import org.nuzhd.vktesttask.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "usersClient", url = "https://jsonplaceholder.typicode.com/users")
public interface UsersClient {

    @GetMapping
    List<User> getAllUsers();

    @GetMapping("/{userId}")
    User getUserById(@PathVariable("userId") Long userId);

    @PostMapping
    User createUser(UserCreateRequest userCreateRequest);

    @PutMapping("/{userId}")
    User updateUser(@PathVariable("userId") Long userId, UserUpdateRequest userUpdateRequest);

    @PatchMapping("/{userId}")
    User patchUser(@PathVariable("userId") Long userId, UserPatchRequest userPatchRequest);

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable("userId") Long userId);

}
