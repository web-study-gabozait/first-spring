package com.ex1012.entity;

import javax.persistence.*;

@Entity
@Table(name="song")
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column(length = 1000)
    private String title;
    private String singer;
    private String composer;

    @Column(name="published_year")
    private int year;

    public SongEntity() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public SongEntity( String title, String singer, String composer, int year) {
        this.title = title;
        this.singer = singer;
        this.composer = composer;
        this.year = year;
    }
}
