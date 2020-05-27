package com.ronnie.first.tutorial.repository;

import com.ronnie.first.tutorial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
