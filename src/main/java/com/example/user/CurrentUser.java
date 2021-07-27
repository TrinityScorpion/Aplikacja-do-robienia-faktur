package com.example.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

@Getter
public class CurrentUser extends User {

    private final com.example.user.User user;

    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities, com.example.user.User user) {
        super(username, password, authorities);
        this.user = user;
    }


}
