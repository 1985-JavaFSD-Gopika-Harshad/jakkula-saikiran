package com.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipe.dto.UserRequestDTO;
import com.recipe.dto.UserResponseDTO;
import com.recipe.service.UserService;

@Controller
@RequestMapping("/api/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
    @PostMapping("/login")
	public String createUser( UserRequestDTO request) {
		 userService.createUser(request);
		return "redirect:/api/users/form";
	}
    
    @PostMapping("/log")
    public String login(UserRequestDTO request, Model model) {
        boolean isAuthenticated = userService.login(request.getEmail(), request.getPassword());
        if (isAuthenticated) {
            return "redirect:/api/users/dashboard";
        } else {
            model.addAttribute("errorMessage", "Invalid email or password.");
            return "redirect:/api/users/form"; // Reload login page with error
        }
    }
    
    
    @GetMapping("/form")
    public String showLoginForm() {
    	return "login";
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
    	return "dashboard";
    }
	
	@GetMapping("/list")
	public String   getAllUsers() {
		 List<UserResponseDTO>users=userService.getAllUsers();
		 return"user";
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "user is deleted successfully with id :"+id;
	}
	
	@GetMapping("/user/{id}")
	public String getUserById(@PathVariable Long id,Model model) {
		UserResponseDTO user=userService.getUserById(id);
		model.addAttribute("user",user);
		return "userDetail";
	}
}