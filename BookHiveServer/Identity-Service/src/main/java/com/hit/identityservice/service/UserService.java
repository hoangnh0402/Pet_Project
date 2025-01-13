package com.hit.identityservice.service;

import com.hit.identityservice.domain.dto.request.UserCreationRequest;
import com.hit.identityservice.domain.dto.request.UserUpdateRequest;
import com.hit.identityservice.domain.dto.response.UserResponse;
import com.hit.identityservice.domain.entity.User;

import java.util.List;

public interface UserService {
    public User createUser(UserCreationRequest request);
    public List<User> getAllUsers();
    public UserResponse getUserById(String userID);
    public UserResponse updateUser(String userID, UserUpdateRequest request);
    public void deleteUser(String userID);
}
