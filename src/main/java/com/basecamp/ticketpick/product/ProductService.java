package com.basecamp.ticketpick.product;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<Integer, Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    public int saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    public void updateProduct(Product product, ProductRequestDTO productRequestDTO) {
        if(productRequestDTO.getName()!=null){
            product.setName(productRequestDTO.getName());
        }
        if(productRequestDTO.getDescription()!=null){
            product.setDescription(productRequestDTO.getDescription());
        }
        if(productRequestDTO.getPrice()<0){
            product.setPrice(productRequestDTO.getPrice());
        }
        if(productRequestDTO.getDate()!=null){
            product.setDate(productRequestDTO.getDate());
        }
        if(productRequestDTO.getVenue()!=null){
            product.setVenue(productRequestDTO.getVenue());
        }
        productRepository.updateProduct(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }
}
