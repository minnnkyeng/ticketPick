package com.basecamp.ticketpick.category;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public int saveCategory(Category category){
        return categoryRepository.saveCategory(category);
    }

    public Category getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public List<Category> getAllCategory(){
        return categoryRepository.getAllCategory();
    }
}
