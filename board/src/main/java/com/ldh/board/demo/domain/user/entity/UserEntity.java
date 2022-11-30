package com.ldh.board.demo.domain.user.entity;


import com.ldh.board.demo.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @Column(length = 20)
    private  String userId;
    private  String password;
    @Column(length = 20)
    private  String name;

    public static UserEntity build(User user) {
        UserEntity entity = new UserEntity();

        entity.setUserId(user.getUserId());
        entity.setName(user.getName());
        entity.setPassword(user.getPassword());

        return entity;
    }

    public UserEntity(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
    }
}
