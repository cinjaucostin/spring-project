package com.costin.erm.service;

import com.costin.erm.entity.Role;
import com.costin.erm.entity.User;
import com.costin.erm.repository.RoleRepository;
import com.costin.erm.repository.UserRepository;
import com.costin.erm.usermodel.RegisterUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Lazy
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void save(RegisterUserModel registerUserModel) {
        User user = new User();
        user.setUsername(registerUserModel.getUsername());
        user.setPassword(passwordEncoder.encode(registerUserModel.getPassword()));
        user.setFirstName(registerUserModel.getFirstName());
        user.setLastName(registerUserModel.getLastName());
        user.setEmail(registerUserModel.getEmail());

        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_EMPLOYEE")));

        userRepository.save(user);
    }

    @Override
    @Transactional
    public void addRoleForUser(String username, String role_name) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(role_name);

        user.getRoles().add(role);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        logger.info(username);

        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }



        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toList())
        );
    }
}
