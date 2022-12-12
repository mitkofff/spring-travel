package com.tu.travel.service;

import com.tu.travel.model.services.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByEmailAndPassword(String email, String password);
}
