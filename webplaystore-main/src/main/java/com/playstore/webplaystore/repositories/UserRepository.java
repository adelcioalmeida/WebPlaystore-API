package com.playstore.webplaystore.repositories;

import com.playstore.webplaystore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
