package com.Veggies.Authenticate.Controller;

import com.Veggies.Authenticate.Exceptions.Usernotfound;
import com.Veggies.Authenticate.Model.Login;
import com.Veggies.Authenticate.Services.LoginService;
import com.Veggies.Authenticate.Services.SecurityToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/userauth")
public class LoginController {

    private LoginService LS;
    private SecurityToken ST;

    @Autowired
    public LoginController(LoginService LS, SecurityToken ST) {
        this.LS = LS;
        this.ST = ST;
    }

    // http://localhost:7200/userauth/Register   [post]
    @PostMapping("/Register")
    public ResponseEntity<?> saveUser(@RequestBody Login user){
        return new ResponseEntity<>(LS.saveUser(user), HttpStatus.CREATED);
    }

    // http://localhost:7200/userauth/Login   [post]
    @PostMapping("/Login")
    public ResponseEntity<?> loginCheck(@RequestBody Login user ) throws Usernotfound {
        Map<String, String> map=null;
        try{
            Login result = LS.authenticateUser(user.getUsername(),user.getPassword());

            map= ST.generateToken(result);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        catch(Usernotfound ex){
            throw new Usernotfound();
        }
        catch(Exception ex){
            return new ResponseEntity<>("Other exception",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
