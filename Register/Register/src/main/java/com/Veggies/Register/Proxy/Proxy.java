package com.Veggies.Register.Proxy;

import com.Veggies.Register.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="authentication-service", url="localhost:7200")
public interface Proxy {
    @PostMapping("/userauth/Register")
    public ResponseEntity<?> saveUser(@RequestBody User user);
}
