package com.example.wiosna.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();
    @Getter
    @Setter
    @OneToOne(mappedBy = "cart")
    private User user;
    public void addItem(Book book, int quantity){
        for(CartItem i : items){
            if(i.getBook() == book){
                i.setQuantity(i.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(this,book,quantity));
    }
    public void removeItem(Book book){
        for (CartItem i : items){
            if(i.getBook() == book){
                if(i.getQuantity() > 1){
                    i.setQuantity(i.getQuantity() - 1);
                }
                else {
                    items.remove(i);
                }
                return;
            }
        }
    }
}


