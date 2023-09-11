package com.basecamp.ticketpick.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<String> findAllProduct() {
        List<Product> products = productService.findAllProduct();
        if(products.isEmpty()){
            return ResponseEntity.ok("no products.");
        }
        return ResponseEntity.ok(products.toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProduct(@PathVariable int id) {
        Product product = productService.findProduct(id);
        if(product==null){
            return ResponseEntity.ok("There is not product, id="+id);
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        if(product==null){
            return ResponseEntity.badRequest().body("Request data is null.");
        }
        int id = productService.saveProduct(product);
        return ResponseEntity.created(URI.create("/products/"+id)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductRequestDTO productRequestDTO) {
        Product product = productService.findProduct(id);
        if(productRequestDTO==null){
            return ResponseEntity.badRequest().body("Request data is null.");
        }
        if(product==null){
            return ResponseEntity.badRequest().body("There is not product, id="+id);
        }
        productService.updateProduct(product, productRequestDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        Product product = productService.findProduct(id);
        if(product==null){
            return ResponseEntity.ok("There is not product, id="+id);
        }
        if(id < 1){
            return ResponseEntity.badRequest().body("Product id is under 1");
        }
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}