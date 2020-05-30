package com.ronnie.first.tutorial.controller;

import java.util.List;

import com.ronnie.first.tutorial.entity.Shop;
import com.ronnie.first.tutorial.exception.ShopNotFoundException;
import com.ronnie.first.tutorial.exception.UserNotFoundException;
import com.ronnie.first.tutorial.repository.ShopRepository;
import com.ronnie.first.tutorial.repository.UserRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    private final ShopRepository repository;
    private final UserRepository userRepository;

    ShopController(ShopRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping("/shops")
    List<Shop> all() {
        return repository.findAll();
    }

    @GetMapping("/users/{id}/shops")
    List<Shop> findAllShopsByUserId(@PathVariable Long id) {
        return repository.findByUserId(id);
    }

    @PostMapping("/shops")
    Shop newShop(@RequestBody Shop newShop) {
        return repository.save(newShop);
    }

    @PostMapping("/users/{userId}/shops")
    Shop newShopByUserId (@PathVariable Long userId, @RequestBody Shop newShop){
        return userRepository.findById(userId).map(user -> {
            newShop.setUser(user);
            return repository.save(newShop);
        }).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @GetMapping("/shops/{id}")
    Shop one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ShopNotFoundException(id));
    }

    @PutMapping("/shops/{id}")
    Shop replaceShop(@RequestBody Shop newShop, @PathVariable Long id) {
        return repository.findById(id)
                .map(shop -> {
                    shop.setName(newShop.getName());
                    shop.setAddress(newShop.getAddress());
                    shop.setUser(newShop.getUser());
                    return repository.save(shop);
                })
                .orElseGet(() -> {
                    newShop.setId(id);
                    return repository.save(newShop);
                });
    }

    @DeleteMapping("/shops/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
