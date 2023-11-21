package com.basecamp.ticketpick.product;

import com.basecamp.ticketpick.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="products")
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int price;
    private String date;
    private String venue;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(int id) {
        this.id = id;
    }

    public Product(String name, String description, int price, String date, String venue, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.date = date;
        this.venue = venue;
        this.category = category;
    }
}