package com.basecamp.ticketpick.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class ProductMapRepository implements ProductRepository{
    private Map<Integer, Product> db = new HashMap<>();
    private int id = 0;

    public List<Product> findAllProduct() {
        List<Product> products = db.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return products;
    }

    public Product findProduct(int id) {
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