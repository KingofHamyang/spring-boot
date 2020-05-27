package com.ronnie.first.demo.repository;

import com.ronnie.first.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
