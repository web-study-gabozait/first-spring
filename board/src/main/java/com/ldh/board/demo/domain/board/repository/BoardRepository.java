package com.ldh.board.demo.domain.board.repository;

import com.ldh.board.demo.domain.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    List<BoardEntity> findAllByOrderByCreatedAtDesc();
}
