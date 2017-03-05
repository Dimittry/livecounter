package com.livecounter.persistence.dao;


import com.livecounter.persistence.model.User;

import java.util.List;

public interface UserRepo {
    List<User> findAll();
    User findByEmail(String email);
    void save(User user);
}
