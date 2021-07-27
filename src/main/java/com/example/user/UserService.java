package com.example.user;

import org.springframework.stereotype.Service;


public interface UserService {

    User findByUserName (String name);
    void saveUser(User user);


}
