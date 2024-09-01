package com.tms.controller;

import com.tms.service.UserService;
import com.tms.util.ControlUtils;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void register() {
        String username = ControlUtils.readInput("Enter username: ");
        String password = ControlUtils.readInput("Enter password: ");
        userService.registerUser(username, password);
        System.out.println("User registered successfully!");
    }

    public boolean login() {
        String username = ControlUtils.readInput("Enter username: ");
        String password = ControlUtils.readInput("Enter password: ");
        boolean isValid = userService.validateUser(username, password);
        if (isValid) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
}
