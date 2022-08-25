package com.Veggies.Authenticate.Services;

import com.Veggies.Authenticate.Model.Login;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class STImp implements SecurityToken{

//    Date date = new Date();
//    long t = date.getTime();
    @Override
    public Map<String, String> generateToken(Login user) {
        String jwttoken = Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"mykey").compact();

        Map<String,String> map = new HashMap<>();
        map.put("token",jwttoken);
        map.put("message","User successfully logged in");
        return map;
    }
}
