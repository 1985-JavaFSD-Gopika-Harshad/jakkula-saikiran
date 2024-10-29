package com.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipe.dto.CategoryDTO;
import com.recipe.service.CategoryService;

@Controller
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	public String createCategory( CategoryDTO request) {
		 categoryService.createCategory(request);
		 return "redirect:/api/categories/all";
	}
	@GetMapping("/show")
	public String showCategoryForm() {
		return "categoryForm";
	}
	
	@GetMapping("/all")
	public String getAllCategories(){
		 List<CategoryDTO> category=categoryService.getAllCategories();
		 return "redirect:/api/categories/cat";
	}
	@GetMapping("/cat")
	public String showCategories() {
		return "category";
	}
	
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return "category is successfully deleted of id :"+id;
	}

}