package com.Veggies.Authenticate.Services;

import com.Veggies.Authenticate.Model.Login;

import java.util.Map;

public interface SecurityToken {
    public abstract Map<String, String> generateToken(Login user);
}
