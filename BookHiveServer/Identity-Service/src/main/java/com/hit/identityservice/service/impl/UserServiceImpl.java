package com.hit.identityservice.service.impl;

import com.hit.identityservice.domain.dto.request.UserCreationRequest;
import com.hit.identityservice.domain.dto.request.UserUpdateRequest;
import com.hit.identityservice.domain.dto.response.UserResponse;
import com.hit.identityservice.domain.entity.User;
import com.hit.identityservice.domain.mapper.UserMapper;
import com.hit.identityservice.exception.AppException;
import com.hit.identityservice.exception.ErrorCode;
import com.hit.identityservice.repository.UserRepository;
import com.hit.identityservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(UserCreationRequest request) {
        if(userRepository.existsByEmail(request.getEmail()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse getUserById(String userID) {
        return userMapper.toUserResponse(userRepository.findById(userID).orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public UserResponse updateUser(String userID, UserUpdateRequest request) {
        User user = userRepository.findById(userID).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(String userID) {
        userRepository.deleteById(userID);
    }
}
