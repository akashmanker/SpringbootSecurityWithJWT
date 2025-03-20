package com.akashcodez.service;

import com.akashcodez.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAll();

    public User addUser(User user);

    public void removeUser(int id);

    public Optional<User> getById(int id);

}
