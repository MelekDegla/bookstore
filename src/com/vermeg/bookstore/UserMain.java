package com.vermeg.bookstore;

import com.vermeg.bookstore.model.User;
import com.vermeg.bookstore.service.implementation.UserServiceImpl;

public class UserMain {
    public static void main(String[] args) {
        UserServiceImpl userService = UserServiceImpl.getInstance();
        User user = new User();
        user.setBirthdate("2020-11-11");
        userService.insert(user);
    }
}
