package com.ex1012.service;

import com.ex1012.domain.Song;

import java.util.List;

public interface SongService {
    /**
     * 새 노래를 등록한다
     *
     * @param song 노래 정보
     * @return 등록된 노래 정보
     */
    public Song addSong(Song song);

    /**
     * 등록된 노래 목록을 가져온다.
     *
     * @return 등록된 노래 목록
     */
    public List<Song> getList();

    public List<Song> getList(String title);

    public List<Song> getList(int year);
    /**
     * 등록된 노래 목록중 한개를 가져온다.
     *
     * @param idx
     * @return 등록된 노래
     */
    public Song read(Long idx);

    /**
     * 등록된 노래 목록중 한개를 수정한다.
     *
     *
     * @param song
     *L
     * @return 수정된 노래
     */
    public void update(Song song);
    public void delete(Long idx);

    List<Song> search(String title, int year);

}
