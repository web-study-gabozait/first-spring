package com.ldh.board.demo.domain.user.service;

import com.ldh.board.demo.domain.user.domain.User;

public interface UserService {

    public User getUser(String userId);

    /**
     * 로그인을 한다
     * @param user 로그인한 유저 정보
     */
    public void postLogin(User user);

    /**
     * 회원가입을 한다
     * @param user
     */
    public void postSignup (User user);

}
