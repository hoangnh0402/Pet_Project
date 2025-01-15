package com.hit.identityservice.controller;

import com.hit.identityservice.domain.dto.request.UserCreationRequest;
import com.hit.identityservice.domain.dto.request.UserUpdateRequest;
import com.hit.identityservice.domain.dto.response.ApiResponse;
import com.hit.identityservice.domain.dto.response.UserResponse;
import com.hit.identityservice.domain.entity.User;
import com.hit.identityservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setData(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserByID/{userID}")
    public UserResponse getUserById(@PathVariable String userID) {
        return userService.getUserById(userID);
    }

    @PutMapping("/updateUser/{userID}")
    public UserResponse updateUser(@PathVariable String userID, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userID, request);
    }

    @DeleteMapping("/deleteUser/{userID}")
    public String deleteUser(@PathVariable String userID) {
        userService.deleteUser(userID);
        return "Deleted User";
    }
}
