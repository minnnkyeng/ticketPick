package com.basecamp.ticketpick.product;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProduct() {
        return productRepository.findAllProduct();
    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);
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
