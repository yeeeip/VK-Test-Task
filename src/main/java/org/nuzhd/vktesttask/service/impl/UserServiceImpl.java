package org.nuzhd.vktesttask.service.impl;

import lombok.RequiredArgsConstructor;
import org.nuzhd.vktesttask.client.PostsClient;
import org.nuzhd.vktesttask.client.UsersClient;
import org.nuzhd.vktesttask.dto.user.UserCreateRequest;
import org.nuzhd.vktesttask.dto.user.UserPatchRequest;
import org.nuzhd.vktesttask.dto.user.UserUpdateRequest;
import org.nuzhd.vktesttask.entity.User;
import org.nuzhd.vktesttask.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersClient usersClient;

    @Override
    @Cacheable("users")
    public List<User> getAllUsers() {
        return usersClient.getAllUsers();
    }

    @Override
    @Cacheable("users")
    public User getUserById(Long userId) {
        return usersClient.getUserById(userId);
    }

    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        return usersClient.createUser(userCreateRequest);
    }

    @Override
    @CachePut(value = "users", key = "#userId")
    public User updateUser(Long userId, UserUpdateRequest userUpdateRequest) {
        return usersClient.updateUser(userId, userUpdateRequest);
    }

    @Override
    @CachePut(value = "users", key = "#userId")
    public User patchUser(Long userId, UserPatchRequest userPatchRequest) {
        return usersClient.patchUser(userId, userPatchRequest);
    }

    @Override
    @CacheEvict("users")
    public void deleteUser(Long userId) {
        usersClient.deleteUser(userId);
    }
}
