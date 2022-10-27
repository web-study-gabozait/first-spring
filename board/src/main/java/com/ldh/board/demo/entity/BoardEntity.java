package com.ldh.board.demo.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardIdx;
    @Column(length = 100)
    private String title;
    @Column(length = 1000)
    private  String content;
    @Column(length = 50)
    private String author;

    private Date created_at;

    private  int watch_count;

    public BoardEntity (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void increaseWatchCount (int watch_count) {
        this.watch_count = watch_count;
    }

}
