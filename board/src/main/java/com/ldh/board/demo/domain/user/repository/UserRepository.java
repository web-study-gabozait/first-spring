package com.ldh.board.demo.domain.user.repository;

import com.ldh.board.demo.domain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
