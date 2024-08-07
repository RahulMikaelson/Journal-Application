package com.varunmatangi.journalApplication.Services;

import com.varunmatangi.journalApplication.Entities.Users;
import com.varunmatangi.journalApplication.Repositories.UserEntityRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserEntityRepositoryInterface userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return User
                .builder()
                .username(user.getUserName())
                .password(user.getPassword())
                .build();
    }

}
