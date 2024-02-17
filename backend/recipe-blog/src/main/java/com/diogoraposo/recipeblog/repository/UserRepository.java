package com.diogoraposo.recipeblog.repository;

import com.diogoraposo.recipeblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
}
