package com.varunmatangi.journalApplication.Services;

import com.varunmatangi.journalApplication.Configuration.SecurityConfiguration;
import com.varunmatangi.journalApplication.Entities.Users;
import com.varunmatangi.journalApplication.Repositories.UserEntityRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {

    @Autowired
    private UserEntityRepositoryInterface repositoryInterface;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    public Users saveUser(Users users){
        users.setRolls(List.of("USER"));
        users.setPassword(securityConfiguration.passwordEncoder().encode(users.getPassword()));
        return repositoryInterface.save(users);
    }

    public Users findByUserName(String userName){
        return repositoryInterface.findByUserName(userName);
    }
}
