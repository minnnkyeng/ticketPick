package com.basecamp.ticketpick.product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAllProduct();
    Product findProduct(int id);
    int saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
}
