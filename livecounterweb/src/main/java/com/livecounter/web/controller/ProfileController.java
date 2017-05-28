package com.livecounter.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

//@Controller
//@RequestMapping(value="/profile")
public class ProfileController {
    @RequestMapping(method = RequestMethod.GET)
//    public String showMainProfilePage(Model model, Principal principal) {
    public String showMainProfilePage(Model model) {
        return "index";
    }
}
