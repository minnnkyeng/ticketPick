package com.basecamp.ticketpick;

import com.basecamp.ticketpick.category.Category;
import com.basecamp.ticketpick.product.Product;
import com.basecamp.ticketpick.product.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductTest {

    @Autowired
    ProductService productService;

    @Test
    public void 상품등록(){
        // given
        Product product = new Product();
        product.setName("캣츠");
        product.setDescription("뮤지컬");
        product.setDate("2023-10-10");
        product.setPrice(3000000);
        product.setVenue("세종문화회관");

        Category category = new Category();
        category.setName("뮤지컬");
        product.setCategory(category);

        // when
        int id = productService.saveProduct(product);

        // then
        Product findProduct = productService.findProduct(id);
        Assertions.assertEquals(product.getName(), findProduct.getName());
    }

    @Test
    public void 상품조회_전체(){
        // given
        Product product1 = new Product();
        product1.setName("캣츠");
        product1.setDescription("뮤지컬");
        product1.setDate("2023-10-10");
        product1.setPrice(3000000);
        product1.setVenue("세종문화회관");

        Category category = new Category();
        category.setName("뮤지컬");
        product1.setCategory(category);

        productService.saveProduct(product1);

        // when
        List<Product> products = productService.findAllProduct();

        // then
        Assertions.assertEquals(1, products.size());
    }

    @Test
    public void 상품조회_id(){
        // given
        Product product = new Product();
        product.setName("캣츠");
        product.setDescription("뮤지컬");
        product.setDate("2023-10-10");
        product.setPrice(3000000);
        product.setVenue("세종문화회관");

        Category category = new Category();
        category.setName("뮤지컬");
        product.setCategory(category);

        productService.saveProduct(product);

        // when
        Product findProduct = productService.findProduct(product.getId());

        // then
        Assertions.assertEquals(product.getId(), findProduct.getId());
    }

    @Test
    public void 상품삭제(){
        // given
        Product product = new Product();
        product.setName("캣츠");
        product.setDescription("뮤지컬");
        product.setDate("2023-10-10");
        product.setPrice(3000000);
        product.setVenue("세종문화회관");

        Category category = new Category();
        category.setName("뮤지컬");
        product.setCategory(category);

        int id = productService.saveProduct(product);

        //when
        productService.deleteProduct(id);

        // then
        Assertions.assertNull(productService.findProduct(id));
    }
}
