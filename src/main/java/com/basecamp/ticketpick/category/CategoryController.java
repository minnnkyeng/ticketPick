package com.basecamp.ticketpick.category;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody Category category){
        log.info("[CategoryController] saveProduct(Category) START" );
        log.info("[CategoryController] saveProduct(Category), category={}", category);
        if(category==null){
            return ResponseEntity.badRequest().body("Request data is null.");
        }
        int id = categoryService.saveCategory(category);
        log.info("[CategoryController] saveProduct(Category) END" );
        return ResponseEntity.created(URI.create("/categories/"+id)).build();
    }

    @GetMapping
    public ResponseEntity<String> getAllCategory(){
        log.info("[CategoryController] findAllCategory() START" );
        List<Category> categories = categoryService.getAllCategory();
        if(categories.isEmpty()){
            return ResponseEntity.ok("no Categories.");
        }
        log.info("[CategoryController] findAllCategory() END" );
        return ResponseEntity.ok(categories.toString());
    }
}
