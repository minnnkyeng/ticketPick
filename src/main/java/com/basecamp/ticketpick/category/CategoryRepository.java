package com.basecamp.ticketpick.category;

import java.util.List;

public interface CategoryRepository {
    public int saveCategory(Category category);

    public Category getCategory(int id);

    public List<Category> getAllCategory();

}
