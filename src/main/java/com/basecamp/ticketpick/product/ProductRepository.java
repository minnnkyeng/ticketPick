package com.basecamp.ticketpick.product;

import java.util.Map;

public interface ProductRepository {
    Map<Integer, Product> getAllProduct();
    Product getProduct(int id);
    int saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
}
