package com.ex1012.service;

import com.ex1012.domain.MyUserDetails;
import com.ex1012.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class SimpleUserDetailService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =null;
        MyUserDetails details = null;

        if(username.equals("foo")) {
            user = new User();
            user.setId("foo");
            user.setPassword("abcd");
            user.setName("푸");
            user.setGrade(1);
            details = new MyUserDetails(user);
        } else if(username.equals("bar")){
            user = new User();
            user.setId("bar");
            user.setPassword("abcd");
            user.setName("바");
            user.setGrade(3);
            details = new MyUserDetails(user);
        }else if(username.equals("tom")){
            user = new User();
            user.setId("tom");
            user.setPassword("1256");
            user.setName("톰");
            user.setGrade(3);
            details = new MyUserDetails(user);
        }

        return null;
    }
}
