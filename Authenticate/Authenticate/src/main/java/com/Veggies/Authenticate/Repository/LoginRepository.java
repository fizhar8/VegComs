package com.Veggies.Authenticate.Repository;

import com.Veggies.Authenticate.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
;
@Repository
public interface LoginRepository  extends JpaRepository<Login, String> {
    public Login findByUsernameAndPassword(String username, String password);
}