package com.example.SpringBootSecurityTest.service;

import com.example.SpringBootSecurityTest.config.MyUserDetails;
import com.example.SpringBootSecurityTest.daoInterface.UserDao;
import com.example.SpringBootSecurityTest.modal.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        Users user = new Users();
        try{
             user = userDao.findByUsername(username);
        }catch (UsernameNotFoundException e){
            System.out.println("No Such username found");
            e.printStackTrace();
        }

        return new MyUserDetails(user);
    }
}
