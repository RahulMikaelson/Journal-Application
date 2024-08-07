package com.varunmatangi.journalApplication.Controllers;

import com.varunmatangi.journalApplication.Entities.Users;
import com.varunmatangi.journalApplication.Services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@RequestBody Users users){
        Users savedUsers = userEntityService.saveUser(users);
        return new ResponseEntity<>(savedUsers,HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Users> getByUserName(@RequestBody Users users){
        Users returnedUsers = userEntityService.findByUserName(users.getUserName());
        return new ResponseEntity<>(returnedUsers,HttpStatus.OK);
    }
}
