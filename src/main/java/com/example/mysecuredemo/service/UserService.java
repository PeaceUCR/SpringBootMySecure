package com.example.mysecuredemo.service;

import com.example.mysecuredemo.entity.User;

public interface UserService {

    public User findByEmail(String email);
}
