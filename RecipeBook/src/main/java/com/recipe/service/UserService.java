package com.recipe.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.dto.UserRequestDTO;
import com.recipe.dto.UserResponseDTO;
import com.recipe.model.User;
import com.recipe.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserResponseDTO createUser(UserRequestDTO request) {
		User user=new User();
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		
		userRepository.save(user);
		return mapToResponse(user);
	}
	public List<UserResponseDTO> getAllUsers(){
		return userRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
	}
	
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public UserResponseDTO getUserById(Long id) {
		User user=userRepository.findById(id).orElseThrow();
		return mapToResponse(user);
		
	}
	private UserResponseDTO mapToResponse(User user) {
		UserResponseDTO dto=new UserResponseDTO();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setEmail(user.getEmail());
		
		return dto;
	}
	
	public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

}
