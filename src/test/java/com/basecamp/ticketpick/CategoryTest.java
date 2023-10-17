package com.basecamp.ticketpick;

import com.basecamp.ticketpick.category.Category;
import com.basecamp.ticketpick.category.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryTest {

    @Autowired
    CategoryService categoryService;

    @Test
    public void 카테고리등록(){
        // given
        Category category = new Category();
        category.setName("뮤지컬");

        // when
        int id = categoryService.saveCategory(category);

        // then
        Category findCategory = categoryService.getCategory(id);
        Assertions.assertEquals(category.getName(), findCategory.getName());
    }
}
