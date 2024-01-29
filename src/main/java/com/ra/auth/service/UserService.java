package com.ra.auth.service;

import com.ra.auth.dto.UserDto;
import com.ra.auth.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserDto userDto);
    Boolean checkPasswordUser(String email,String password);
    Boolean checkUserByEmail(String email);
    User getUserbyEmail(String email);
}
