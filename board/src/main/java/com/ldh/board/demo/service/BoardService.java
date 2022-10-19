package com.ldh.board.demo.service;

import com.ldh.board.demo.domain.Board;

import java.util.List;

public interface BoardService {

    public Board postBoard(Board board);

    public List<Board> getBoards();

    public Board getBoard(Long idx);

    public void increaseWatchCount(Long idx);

    public void fetchBoard(Long idx, Board board);

    public void deleteBoard(Long idx);

}
