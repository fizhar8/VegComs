package com.Veggies.Authenticate.Services;

import com.Veggies.Authenticate.Exceptions.Usernotfound;
import com.Veggies.Authenticate.Model.Login;

import java.util.List;

public interface LoginService {
    public abstract Login saveUser(Login user);
    public abstract Login authenticateUser(String username,String pwd) throws Usernotfound;


}