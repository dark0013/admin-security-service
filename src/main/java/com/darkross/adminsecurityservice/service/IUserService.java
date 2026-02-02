package com.darkross.adminsecurityservice.service;

import com.darkross.adminsecurityservice.dto.request.CreateUserRequest;

public interface IUserService {
    void createUser(CreateUserRequest request);
}
