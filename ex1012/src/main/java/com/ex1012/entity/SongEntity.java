package com.ex1012.entity;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class SongEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 1000)
    private String title;

    @ManyToOne(targetEntity = ArtistEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_idx")
    private ArtistEntity artist;

    private String composer;

    @Column(name = "published_year")
    private int year;

    public SongEntity() {

    }

    public SongEntity(Long idx, String title, String composer, int year) {
        this.idx = idx;
        this.title = title;
        this.composer = composer;
        this.year = year;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArtistEntity getArtist() {
        return artist;
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
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
