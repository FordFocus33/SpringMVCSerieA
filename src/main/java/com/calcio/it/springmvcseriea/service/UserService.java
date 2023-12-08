package com.calcio.it.springmvcseriea.service;

import com.calcio.it.springmvcseriea.dto.RegistrationDto;
import com.calcio.it.springmvcseriea.entity.UserEntity;

public interface UserService {

    // This service unites service for User and Role

    void save(RegistrationDto registrationDto);
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);
}
