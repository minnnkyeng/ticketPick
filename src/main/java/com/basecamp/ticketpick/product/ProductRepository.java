package com.basecamp.ticketpick.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    private Map<Integer, Product> db = new HashMap<>();
    private int id = 0;

    public String getAllProduct() {
        return db.toString();
    }

    public Product getProduct(int id) {
        return db.get(id);
    }

    public String saveProduct(Product product) {
        product.setId(++id);
        db.put(id, product);
        return id + " 등록 완";
    }

    public String updateProduct(Product product) {
        db.put(product.getId(), product);
        return db.get(product.getId()).toString();
    }

    public String deleteProduct(int id) {
        db.remove(id);
        return id + " 삭제 완";
    }
}