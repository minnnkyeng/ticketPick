package com.basecamp.ticketpick.category;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CategoryJPARepository implements CategoryRepository{

    private final EntityManager entityManager;

    public CategoryJPARepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public int saveCategory(Category category) {
        entityManager.persist(category);
        return category.getId();
    }

    @Override
    public Category getCategory(int id){
        return entityManager.find(Category.class, id);
    }

    @Override
    public List<Category> getAllCategory() {
        return entityManager.createQuery("select c from Category c").getResultList();
    }
}
