package com.livecounter.persistence.dao.impl;

import com.livecounter.persistence.dao.UserRepo;
import com.livecounter.persistence.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.NoResultException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-config.xml"})
public class UserRepoImplTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void testFindAll() throws Exception {
        List<User> userList = userRepo.findAll();
        User user = userList.get(0);
        assertEquals(1, userList.size());
    }

    @Test
    public void testFindByEmail() throws Exception {
        User user = userRepo.findByEmail("test@test.con");
        assertNotNull(user);
        assertEquals("test1", user.getFirstName());
    }

    @Test(expected = NoResultException.class)
    public void testNotFindByEmail() {
        User user = userRepo.findByEmail("test@test.com");
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setFirstName("test2fn");
        user.setLastName("test2ln");
        user.setPassword("testpass2");
        user.setEmail("test2@test2.com");
        userRepo.save(user);
    }

}