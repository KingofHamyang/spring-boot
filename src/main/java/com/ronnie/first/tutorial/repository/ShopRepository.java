package com.ronnie.first.tutorial.repository;

import com.ronnie.first.tutorial.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findByUserId(Long userId);
}
