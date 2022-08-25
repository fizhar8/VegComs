package com.Veggies.Register.Services;



import com.Veggies.Register.Exceptions.Userexists;
import com.Veggies.Register.Model.User;

import java.util.List;

public interface UserService {
    User addUser(User user) throws Userexists;


}
