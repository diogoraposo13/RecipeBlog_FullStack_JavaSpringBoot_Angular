package com.diogoraposo.recipeblog.service;

import com.diogoraposo.recipeblog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public User findUserById(Long userId) throws Exception;
    public User createUser(User user) throws Exception;
    public List<User> getAllUsers();
    public void deleteUser(Long id);



}
