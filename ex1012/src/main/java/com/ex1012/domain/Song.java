package com.ex1012.domain;

public class Song {

    public Song(String title, String singer, String composer, int year) {
        this.title = title;
        this.singer = singer;
        this.composer = composer;
        this.year = year;
    }

    private Long idx;
    private String title;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    private String singer;

    private String composer;

    private int year;

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
}
