package com.example.SpringBootSecurityTest.daoInterface;

import com.example.SpringBootSecurityTest.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
