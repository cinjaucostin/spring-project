package com.costin.erm.service;

import com.costin.erm.entity.User;
import com.costin.erm.usermodel.RegisterUserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUsername(String username);
    User findByEmail(String email);
    void save(RegisterUserModel registerUserModel);
    void addRoleForUser(String username, String role_name);

}
