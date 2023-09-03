package com.basecamp.ticketpick.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductMapRepository implements ProductRepository{
    private Map<Integer, Product> db = new HashMap<>();
    private int id = 0;

    public Map<Integer, Product> getAllProduct() { return db; }

    public Product getProduct(int id) {
        return db.get(id);
    }

    public int saveProduct(Product product) {
        product.setId(++id);
        db.put(id, product);
        return id;
    }

    public void updateProduct(Product product) {
        db.put(product.getId(), product);
    }

    public void deleteProduct(int id) {
        db.remove(id);
    }
}