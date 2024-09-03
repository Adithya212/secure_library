package com.ust.secure_library.controller;

import com.ust.secure_library.model.User;
import com.ust.secure_library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    // http://localhost:8080/api/v1/create-user
    // {
    //    "username" : "user",
    //    "password" : "pass"
    //}
    @PostMapping("/create-user")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // ...
        return ResponseEntity.ok().body(libraryService.register(user));
    }


    // http://localhost:8080/api/v1/renew-user-subscription/1
    @PostMapping("/issue-book")
    public ResponseEntity<String> issueBook(@RequestParam("ID") long id) {
        return ResponseEntity.ok().body(libraryService.issueBook(id));
    }


    // http://localhost:8080/api/v1/issue-book?ID=1
    // or
    // http://localhost:8080/api/v1/issue-book
    // with body -> from-data -> key: ID, Value: 1
    @GetMapping("/renew-user-subscription/{id}")
    public ResponseEntity<HttpStatus> renewSubscription(@PathVariable long id) {

        libraryService.renewSub(id);
        return ResponseEntity.ok().build();
    }

}
