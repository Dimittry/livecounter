package com.livecounter.persistence.dao;


import com.livecounter.persistence.model.Privilege;
import com.livecounter.persistence.model.Role;
import com.livecounter.persistence.model.User;

import java.util.List;

public interface UserRepo {
    List<User> findAll();

    User findByEmail(String email);

    User save(User user);

}
