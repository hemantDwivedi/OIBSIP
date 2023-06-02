package com.oasis.onlinereservationsystem.repository;

import com.oasis.onlinereservationsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getByUsernameAndPassword(String username, String password);
}
