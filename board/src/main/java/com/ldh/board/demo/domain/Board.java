package com.ldh.board.demo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Board {

    public Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    private  Long boardIdx;
    private String title;
    private  String content;
    private String author;
    private Date created_at;
    private int watch_count;
}
