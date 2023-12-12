package com.calcio.it.springmvcseriea.service;

import com.calcio.it.springmvcseriea.dto.RegistrationDto;
import com.calcio.it.springmvcseriea.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
