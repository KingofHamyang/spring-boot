package com.ronnie.first.tutorial.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    private @Id @GeneratedValue Long id;
    private String name;
    private String role;
    private String password;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Shop> shops;

    public User() {}

    public User(String name, String role, String password) {
        this.name = name;
        this.role = role;
        this.password = password;
    }
}
