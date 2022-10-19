package com.ex1012.entity;

import javax.persistence.*;

@Entity
@Table(name="artist")
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int artistIdx;

    private String name;

    private int debutYear;


    public int getArtistIdx() {
        return artistIdx;
    }

    public void setArtistIdx(int artistIdx) {
        this.artistIdx = artistIdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDebutYear() {
        return debutYear;
    }

    public void setDebutYear(int debutYear) {
        this.debutYear = debutYear;
    }
}
