package com.example.user;

import org.springframework.stereotype.Service;


public interface UserService {
    User findByUserName (String name);
    User findUserById(long id);
    void saveUser(User user);


}
