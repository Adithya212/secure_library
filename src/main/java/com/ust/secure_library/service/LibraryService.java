package com.ust.secure_library.service;

import com.ust.secure_library.model.User;
import com.ust.secure_library.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@Slf4j
public class LibraryService {
    @Autowired
    private UserRepo userRepository;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    // Methods for user registration, login, subscription, and issue retrieval
    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setSubscription(false);
        return userRepository.save(user);
    }

    public void renewSub(long id) {
        var user = userRepository.findById(id).get();
        user.setSubscription(true);
        userRepository.save(user);
    }

    public String issueBook(long id) {
        var user = userRepository.findById(id).get();
        if (user.isSubscription()) {
            return "Issue success";
        } else {
            throw new RuntimeException("Subscription Expired");
        }
    }
}