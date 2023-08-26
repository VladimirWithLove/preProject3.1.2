package com.example.PP_3_1_2.service;

import com.example.PP_3_1_2.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAllUsers();
    User getUser(long id);
    void deleteUser(long id);
    void updateUser(long id, User user);
}
