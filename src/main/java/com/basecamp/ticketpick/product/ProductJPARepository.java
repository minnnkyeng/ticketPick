package com.basecamp.ticketpick.product;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductJPARepository implements ProductRepository {
    private final EntityManager entityManager;

    public ProductJPARepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> findAllProduct() {
        return null;
    }

    @Override
    public Product findProduct(int id) {
        return null;
    }

    @Override
    public int saveProduct(Product product) {
        entityManager.persist(product);
        return product.getId();
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(int id) {

    }
}
