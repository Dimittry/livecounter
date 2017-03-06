package com.livecounter.service.impl;

import com.livecounter.exceptions.EmailExistException;
import com.livecounter.persistence.model.User;
import com.livecounter.service.UserService;
import com.livecounter.web.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-config.xml"})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    private UserDto userDto;

    @Before
    public void setUp() {
        userDto = makeDto();
    }

    @Test
    public void testRegisterNewUserAccount() throws Exception {
        User user = userService.registerNewUserAccount(userDto);
        assertNotNull(user);
        assertEquals(Long.valueOf(6), user.getId());
    }

    @Test(expected = EmailExistException.class)
    public void testNotRegisterNewUserAccount() throws Exception {
        User user = userService.registerNewUserAccount(userDto);
        assertNotNull(user);
        assertEquals(Long.valueOf(6), user.getId());
    }

    private UserDto makeDto() {
        UserDto userDto = new UserDto();
        userDto.setFirstName("Vasya");
        userDto.setLastName("Pupkin");
        userDto.setPassword("pupkin_mega_pass");
        userDto.setEmail("pupkin2@pupa.com");
        return userDto;
    }
}