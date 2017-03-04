package com.livecounter.persistence.dao.impl;

import com.livecounter.persistence.dao.UserRepo;
import com.livecounter.persistence.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-config.xml"})
public class UserRepoImplTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void findAll() throws Exception {
        List<User> userList = userRepo.findAll();
        User user = userList.get(0);
        assertEquals(1, userList.size());
    }

}