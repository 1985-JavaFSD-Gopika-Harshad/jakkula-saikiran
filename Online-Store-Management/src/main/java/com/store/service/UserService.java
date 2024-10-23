package com.store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.UserRequestDTO;
import com.store.dto.UserResponseDTO;
import com.store.model.User;
import com.store.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO registerUser(UserRequestDTO request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return mapToUserResponseDTO(user);
    }
    public List<UserResponseDTO> getAllUsers() {
    	return userRepository.findAll().stream().map(this::mapToUserResponseDTO).collect(Collectors.toList());
    }
    public UserResponseDTO updateUser(Long userId, UserRequestDTO request) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Update user fields
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword()); // Consider hashing passwords in a real application

        userRepository.save(user);

        return mapToUserResponseDTO(user);
    }
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        userRepository.delete(user);
    }

    private UserResponseDTO mapToUserResponseDTO(User user) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setUsername(user.getUsername());
        return responseDTO;
    }
}
