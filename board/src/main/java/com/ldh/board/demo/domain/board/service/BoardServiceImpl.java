package com.ldh.board.demo.domain.board.service;

import com.ldh.board.demo.domain.board.domain.Board;
import com.ldh.board.demo.domain.board.entity.BoardEntity;
import com.ldh.board.demo.domain.board.repository.BoardRepository;
import com.ldh.board.demo.domain.board.service.BoardService;
import com.ldh.board.demo.domain.user.domain.User;
import com.ldh.board.demo.domain.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service(value="boardService")
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    @Autowired
    private void setBoardRepository(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board getBoard(Long idx) {

        Optional<BoardEntity> optional = boardRepository.findById(idx);

        if(optional.isPresent()){
            this.increaseWatchCount(idx);
            BoardEntity entity = optional.get();
            User handleUser = User.build(entity.getAuthor());

            Board board = new Board(entity.getTitle(), entity.getContent(), handleUser);
            board.setBoardIdx(entity.getBoardIdx());
            board.setCreatedAt(entity.getCreatedAt());
            board.setWatchCount(entity.getWatchCount());

            return board;
        }else {
            throw new IllegalArgumentException("잘못된 IDX 입니다");
        }
    }

    @Override
    public void increaseWatchCount(Long idx) {
        BoardEntity boardEntity = boardRepository.findById(idx).orElseThrow();
        boardEntity.increaseWatchCount(boardEntity.getWatchCount() + 1);
        boardRepository.save(boardEntity);
    }

    @Override
    public List<Board> getBoards() {

        List<BoardEntity> boardList = boardRepository.findAllByOrderByCreatedAtDesc();
        List<Board> handleBoardList = new ArrayList<>();
        for(BoardEntity board : boardList) {

            User handleUser =  User.build(board.getAuthor());

            Board handleBoard = new Board(board.getTitle(), board.getContent(), handleUser);
            handleBoard.setBoardIdx(board.getBoardIdx());
            handleBoard.setWatchCount(board.getWatchCount());
            handleBoard.setCreatedAt(board.getCreatedAt());

            handleBoardList.add(handleBoard);
        }

        return handleBoardList;
    }

    @Override
    public Board postBoard(Board board) {

        UserEntity handleUser = UserEntity.build(board.getAuthor());

        BoardEntity boardEntity = new BoardEntity(
                board.getTitle(),
                board.getContent(),
                handleUser);

        boardEntity.setCreatedAt(new Date());
        boardEntity.setWatchCount(0);
        boardRepository.save(boardEntity);

        return board;
    }

    @Override
    public void fetchBoard(Long idx, Board board) {

        Optional<BoardEntity> optional = boardRepository.findById(idx);

        if(optional.isPresent()) {
            BoardEntity entity = optional.get();
            entity.setTitle(board.getTitle());
            entity.setContent(board.getContent());
            entity.setAuthor(entity.getAuthor());
            boardRepository.save(entity);
        }


    }

    @Override
    public void deleteBoard(Long idx) {
        boardRepository.deleteById(idx);
    }
}
