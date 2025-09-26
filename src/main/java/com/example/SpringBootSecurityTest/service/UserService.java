package com.example.SpringBootSecurityTest.service;

import com.example.SpringBootSecurityTest.daoInterface.UserDao;
import com.example.SpringBootSecurityTest.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    public Users register(Users user) {
            user.setPassword(encoder.encode(user.getPassword()));
            return userDao.save(user);
    }

    public String verify(Users user) {
       // user.setPassword(encoder.encode(user.getPassword()));

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }

        return "Username or Password does not Match";
    }
}
