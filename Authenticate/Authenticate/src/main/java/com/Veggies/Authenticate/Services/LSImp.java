package com.Veggies.Authenticate.Services;

import com.Veggies.Authenticate.Exceptions.Usernotfound;
import com.Veggies.Authenticate.Model.Login;
import com.Veggies.Authenticate.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LSImp implements LoginService {
    private LoginRepository userRepository;

    @Autowired
    public LSImp(LoginRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Login saveUser(Login user) {
        return userRepository.save(user);
    }

    @Override
    public Login authenticateUser(String uid, String pwd) throws Usernotfound {
        Login user = userRepository.findByUsernameAndPassword(uid, pwd);
        if (user != null) { //authentication is ok
            return user;
        } else { // authentication failed
            throw new Usernotfound();
        }
    }
}