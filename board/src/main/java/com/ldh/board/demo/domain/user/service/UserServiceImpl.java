package com.ldh.board.demo.domain.user.service;

import com.ldh.board.demo.domain.user.domain.User;
import com.ldh.board.demo.domain.user.entity.UserEntity;
import com.ldh.board.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service(value = "userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    @Override
    public User getUser(String userId) {
        Optional<UserEntity> optional = userRepository.findById(userId);
        if(optional.isPresent()) {
            return User.build(optional.get());
        }else {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
    }

    @Override
    public void postLogin(User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserId(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public void postSignup(User user) {
        UserEntity entity = UserEntity.build(user);
        entity.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(entity);
    }
}
