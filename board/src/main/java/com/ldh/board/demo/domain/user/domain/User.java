package com.ldh.board.demo.domain.user.domain;

import com.ldh.board.demo.domain.user.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String userId;
    private String password;
    private String name;

    private User() {

    }

    public User(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }

    public static User build(UserEntity entity) {
        User user = new User();
        user.setUserId(entity.getUserId());
        user.setName(entity.getName());
        user.setPassword(entity.getPassword());

        return user;
    }

}
