package com.ust.secure_library.service;

import com.ust.secure_library.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var libUser = userRepo.findByUsername(username);
        return User
                .builder()
                .username(libUser.getUsername())
                .password(libUser.getPassword())
                .authorities("ADMIN")
                .build();
    }
}
