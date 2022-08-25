package com.Veggies.Register.Services;

import com.Veggies.Register.Model.User;

import com.Veggies.Register.Exceptions.Userexists;
import com.Veggies.Register.Proxy.Proxy;
import com.Veggies.Register.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class USImp implements UserService {

    @Autowired
    private UserRepository UR;

    @Autowired
    private Proxy proxy;

    @Override
    public User addUser(User user) throws Userexists {
        if(UR.findById(user.getEmail()).isEmpty()){
            User result = UR.insert(user);
            ResponseEntity<?> response = proxy.saveUser(user);
            System.out.println(response);
            return result;
        }
        else{
            throw new Userexists();
        }
    }
}






