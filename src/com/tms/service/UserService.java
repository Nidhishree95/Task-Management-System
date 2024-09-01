package com.tms.service;

import com.tms.dao.UserDAO;
import com.tms.model.User;

public class UserService {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(String username, String password) {
        User user = new User(username, password);
        userDAO.saveUser(user);
    }

    public boolean validateUser(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
