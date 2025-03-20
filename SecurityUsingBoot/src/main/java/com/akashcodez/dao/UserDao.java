package com.akashcodez.dao;

import com.akashcodez.entity.User;
import com.akashcodez.repos.UserRepository;
import com.akashcodez.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDao implements UserService {

//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
//         user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
         return  userRepository.save(user);
    }

    @Override
    public void removeUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }


}
