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

    @ManyToOne(targetEntity = ArtistEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_idx")
    private ArtistEntity aritist;
    private String composer;

    public ArtistEntity getArtist() {
        return aritist;
    }

    public void setArtist(ArtistEntity aritist) {
        this.aritist = aritist;
    }

    @Column(name="published_year")
    private int year;

    public SongEntity() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public SongEntity( String title, String composer, int year) {
        this.title = title;
        this.composer = composer;
        this.year = year;
    }
}
