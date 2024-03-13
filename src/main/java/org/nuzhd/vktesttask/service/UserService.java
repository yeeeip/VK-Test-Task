package org.nuzhd.vktesttask.service;

import org.nuzhd.vktesttask.dto.user.UserCreateRequest;
import org.nuzhd.vktesttask.dto.user.UserPatchRequest;
import org.nuzhd.vktesttask.dto.user.UserUpdateRequest;
import org.nuzhd.vktesttask.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long userId);

    User createUser(UserCreateRequest userCreateRequest);

    User updateUser(Long userId, UserUpdateRequest userUpdateRequest);

    User patchUser(Long userId, UserPatchRequest userPatchRequest);

    void deleteUser(Long userId);

}
