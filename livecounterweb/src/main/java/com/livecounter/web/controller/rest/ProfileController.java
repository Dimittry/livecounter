package com.livecounter.web.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value="/rest/")
public class ProfileController {
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<String> getUserProfile(Principal principal) {
        System.out.println(principal);
        return  new ResponseEntity<String>("profile", HttpStatus.OK);
    }
}
