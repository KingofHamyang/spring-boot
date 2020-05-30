package com.ronnie.first.tutorial.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shops")
public class Shop {
    private @Id @GeneratedValue Long id;
    private String name;
    private String address;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Shop() {}

    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
