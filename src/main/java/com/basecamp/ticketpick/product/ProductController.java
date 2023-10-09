package com.basecamp.ticketpick.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<String> findAllProduct() {
        log.info("[ProductController] findAllProduct() START" );
        List<Product> products = productService.findAllProduct();
        if(products.isEmpty()){
            return ResponseEntity.ok("no products.");
        }
        log.info("[ProductController] findAllProduct() END" );
        return ResponseEntity.ok(products.toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProduct(@PathVariable int id) {
        log.info("[ProductController] findProduct(int) START" );
        log.info("[ProductController] findProduct(int), id={}", id);
        Product product = productService.findProduct(id);
        if(product==null){
            return ResponseEntity.ok("There is not product, id="+id);
        }
        log.info("[ProductController] findAllProduct() END" );
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        log.info("[ProductController] saveProduct(Product) START" );
        log.info("[ProductController] saveProduct(Product), product={}", product);
        if(product==null){
            return ResponseEntity.badRequest().body("Request data is null.");
        }
        int id = productService.saveProduct(product);
        log.info("[ProductController] saveProduct(Product) END" );
        return ResponseEntity.created(URI.create("/products/"+id)).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody ProductRequestDTO productRequestDTO) {
        log.info("[ProductController] updateProduct(int, ProductRequestDTO) START" );
        log.info("[ProductController] updateProduct(int, ProductRequestDTO), id={}, productRequestDTO={}", id, productRequestDTO);
        Product product = productService.findProduct(id);
        if(productRequestDTO==null){
            return ResponseEntity.badRequest().body("Request data is null.");
        }
        if(product==null){
            return ResponseEntity.badRequest().body("There is not product, id="+id);
        }
        productService.updateProduct(product, productRequestDTO);
        log.info("[ProductController] findAllProduct() END" );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        log.info("[ProductController] deleteProduct(int) START" );
        log.info("[ProductController] deleteProduct(int), id={}", id);
        Product product = productService.findProduct(id);
        if(product==null){
            return ResponseEntity.ok("There is not product, id="+id);
        }
        if(id < 1){
            return ResponseEntity.badRequest().body("Product id is under 1");
        }
        productService.deleteProduct(id);
        log.info("[ProductController] deleteProduct(int) END" );
        return ResponseEntity.noContent().build();
    }
}