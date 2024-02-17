package com.diogoraposo.recipeblog.service;

import com.diogoraposo.recipeblog.model.User;
import com.diogoraposo.recipeblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(Long userId) throws Exception {

        Optional<User> opt =  userRepository.findById(userId);

        if(opt.isPresent()){
            return opt.get();
        }

        throw new Exception("user not found with id " +userId);
    }

    @Override
    public User createUser(User user) throws Exception {
        User isExist = userRepository.findByEmail(user.getEmail());

        if(isExist != null){
            throw new Exception("user exist with " + user.getEmail());
        }

        User savedUser = userRepository.save(user);

        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
