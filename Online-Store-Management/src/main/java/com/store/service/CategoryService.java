package com.store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.CategoryRequestDTO;
import com.store.dto.CategoryResponseDTO;
import com.store.model.Category;
import com.store.repository.CategoryRepository;

@Service
public class CategoryService {
		
	
	@Autowired
	private CategoryRepository categoryRepositoty;
	
	
	public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
		Category category=new Category();
		category.setName(request.getName());
		categoryRepositoty.save(category);
		
		
		return mapToDTO(category);
	}
	
	public List<CategoryResponseDTO> getAllCategories(){
		return categoryRepositoty.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	public void deleteCategory(Long id) {
		categoryRepositoty.deleteById(id);
	}
	
	
	private CategoryResponseDTO mapToDTO(Category category) {
		CategoryResponseDTO dto=new CategoryResponseDTO();
		dto.setId(category.getId());
		dto.setName(category.getName());
		return dto;
	}
	
}
