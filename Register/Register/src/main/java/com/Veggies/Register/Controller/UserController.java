package com.Veggies.Register.Controller;

import com.Veggies.Register.Exceptions.Userexists;
import com.Veggies.Register.Model.User;
import com.Veggies.Register.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService US;

    // http://localhost:7100/user/register   [post]
    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody User user) throws Userexists{
        try{
            return new ResponseEntity<>(US.addUser(user), HttpStatus.OK);
        }
        catch (Exception ex) {
            throw new Userexists();
        }
    }

    }
