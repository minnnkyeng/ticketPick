package com.basecamp.ticketpick.product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getAllProduct() {
        return productRepository.getAllProduct();
    }

    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    public String saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    public String updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    public String deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }
}