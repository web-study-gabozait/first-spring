package com.ex1012.service;

import com.ex1012.domain.Artist;
import com.ex1012.domain.Song;
import com.ex1012.entity.ArtistEntity;
import com.ex1012.entity.SongEntity;
import com.ex1012.repository.ArtistRepository;
import com.ex1012.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value="songService")
public class SongServiceImpl implements SongService{

    private SongRepository songRepository;
    private ArtistRepository artistRepository;

    @Autowired
    private void setSongRepository(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Autowired
    private  void setArtistRepository(ArtistRepository artistRepository) {this.artistRepository = artistRepository;}
    @PostConstruct
    public void prepare() {
        ArtistEntity artist = new ArtistEntity();
        artist.setName("BTS");
        artist.setDebutYear(2013);
        artistRepository.save(artist);
        SongEntity songEntity = new SongEntity();
        songEntity.setYear(2020);
        songEntity.setComposer("BTS");
        songEntity.setTitle("다이너마이트");
        songEntity.setArtist(artist);

        artist = new ArtistEntity();
        artist.setName("블랙핑크");
        artist.setDebutYear(2015);
        artistRepository.save(artist);

        artist = new ArtistEntity();
        artist.setName("아이유");
        artist.setDebutYear(2005);
        artistRepository.save(artist);

    }


    @Override
    public Song addSong(Song song) {

        SongEntity songEntity = new SongEntity(
                song.getTitle(),
                song.getComposer(),
                song.getYear());

        songRepository.save(songEntity);

        return song;
    }

    @Override
    public List<Song> getList() {
        List<SongEntity> list =  songRepository.findAll();

        List<Song> result = new ArrayList<>();
        for (SongEntity item : list) {
            Song song = new Song(item.getTitle(), item.getComposer(), item.getYear());
            song.setIdx(item.getIdx());

            result.add(song);
        }

        return result;
    }

    @Override
    public Song read(Long idx) {
        Optional<SongEntity> optional = songRepository.findById(idx);

        if(optional.isPresent()) {
            SongEntity entity = optional.get();
            Song song = new Song(entity.getTitle(), entity.getComposer(), entity.getYear());
            song.setIdx(entity.getIdx());

            Artist artist = new Artist();
            artist.setArtistIdx(entity.getArtist().getArtistIdx());
            artist.setDebutYear(entity.getArtist().getDebutYear());
            artist.setName(entity.getArtist().getName());


            return song;
        }else {
            throw new IllegalArgumentException("잘못된 IDX 입니다");

    }

    @Override
    public void modify(Long idx, Song song) {

        Optional<SongEntity> optional = songRepository.findById(idx);

        if(optional.isPresent()){
            SongEntity entity = optional.get();
            entity.setIdx(idx);
            entity.setTitle(song.getTitle());
            entity.setComposer(song.getComposer());
            entity.setYear(song.getYear());
            songRepository.save(entity);
        }
    }

    @Override
    public void delete(Long idx) {
      songRepository.deleteById(idx);

    }
}
