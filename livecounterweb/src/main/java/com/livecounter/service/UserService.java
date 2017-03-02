package com.livecounter.service;

import com.livecounter.exceptions.EmailExistException;
import com.livecounter.persistence.model.User;
import com.livecounter.web.dto.UserDto;

public interface UserService {
    User registerNewUserAccount(UserDto accountDto) throws EmailExistException;
}
