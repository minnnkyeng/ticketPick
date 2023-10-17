package com.basecamp.ticketpick.category;

import java.util.List;

public interface CategoryRepository {
    int saveCategory(Category category);

    Category getCategory(int id);

    List<Category> getAllCategory();
}
