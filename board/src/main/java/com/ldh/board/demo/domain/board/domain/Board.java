package com.ldh.board.demo.domain.board.domain;

import com.ldh.board.demo.domain.user.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Board {

    public Board(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    private  Long boardIdx;
    private String title;
    private  String content;
    private User author;
    private Date createdAt;
    private int watchCount;
}
