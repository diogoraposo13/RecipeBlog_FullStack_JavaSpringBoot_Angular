package com.diogoraposo.recipeblog.controller;

import com.diogoraposo.recipeblog.model.User;
import com.diogoraposo.recipeblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/api/users/profile")
    private User findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception {

        User user= userService.findUserByJwt(jwt);

        return user;
    }



}
