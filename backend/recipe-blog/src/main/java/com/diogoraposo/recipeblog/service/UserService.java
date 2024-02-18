package com.diogoraposo.recipeblog.service;

import com.diogoraposo.recipeblog.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public User findUserById(Long userId) throws Exception;

    public User findUserByJwt(String jwt) throws Exception;



}
