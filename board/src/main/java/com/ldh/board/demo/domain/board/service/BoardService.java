package com.ldh.board.demo.domain.board.service;

import com.ldh.board.demo.domain.board.domain.Board;

import java.util.List;

public interface BoardService {

    /**
     * 새 게시물을 등록한다
     * @param board 게시물 정보
     * @return 등록된 게시물 정보
     */
    public Board postBoard(Board board);

    /**
     * 등록된 게시물들을 조회한다
     *
     * @return 등록된 게시물들 정보
     */
    public List<Board> getBoards();

    /**
     * 등록된 게시물을 조회한다
     * @param idx 등록된 게시물의 idx
     * @return 등록된 게시물 정보
     */
    public Board getBoard(Long idx);

    /**
     * 특정 등록된 게시물의 조회수를 증가한다.
     * @param idx 특정 등록된 게시물의 idx
     */
    public void increaseWatchCount(Long idx);

    /**
     * 등록된 게시물을 수정한다.
     * @param idx 등록된 게시물의 idx
     * @param board 등록된 게시물의 정보
     */
    public void fetchBoard(Long idx, Board board);

    /**
     * 등록된 게시물을 삭제한다
     * @param idx 등록된 게시물의 idx
     */
    public void deleteBoard(Long idx);

}
