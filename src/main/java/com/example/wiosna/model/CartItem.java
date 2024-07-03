package com.example.wiosna.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity

public class CartItem {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @Getter
    @Setter
    @ManyToOne
    private Book book;
    @Getter
    @Setter
    private int quantity;
    public CartItem(Cart cart, Book book, int quantity){
        this.cart=cart;
        this.book=book;
        this.quantity=quantity;
    }
    public CartItem(){}

}
