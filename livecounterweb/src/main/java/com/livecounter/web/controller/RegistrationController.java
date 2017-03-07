package com.livecounter.web.controller;


import com.livecounter.exceptions.EmailExistException;
import com.livecounter.persistence.model.User;
import com.livecounter.service.UserService;
import com.livecounter.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @RequestMapping(value="/user/show", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto userDto,
            BindingResult result,
            WebRequest request,
            Errors errors
    ) {
        User registered = new User();
        if(!result.hasErrors()) {
            registered = createUserAccount(userDto, result );
        }
        if(registered == null) {
            result.rejectValue("email", "message.error");
        }
        if(result.hasErrors()) {
            return new ModelAndView("registration", "user", userDto);
        } else {
            return new ModelAndView("successRegister", "user", userDto);
        }
    }

    private User createUserAccount(UserDto userDto, BindingResult result) {
        User registered = null;
        try {
            registered = userService.registerNewUserAccount(userDto);
        } catch (EmailExistException e) {
            return null;
        }
        return registered;
    }
}
