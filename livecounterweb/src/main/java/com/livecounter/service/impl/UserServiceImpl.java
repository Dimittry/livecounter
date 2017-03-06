package com.livecounter.service.impl;

import com.livecounter.exceptions.EmailExistException;
import com.livecounter.persistence.dao.UserRepo;
import com.livecounter.persistence.model.User;
import com.livecounter.service.UserService;
import com.livecounter.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User registerNewUserAccount(UserDto userDto) throws EmailExistException {
        if(isEmailExist(userDto.getEmail())) {
            throw new EmailExistException("There is an account with that email address: " +
                    userDto.getEmail());
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return userRepo.save(user);
    }

    private boolean isEmailExist(final String email) {
        User user = userRepo.findByEmail(email);
        return (user != null);
    }
}
