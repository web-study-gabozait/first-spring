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
     * @param idx
     * @param song
     *
     * @return 수정된 노래
     */
    public void modify(Long idx, Song song);

    public void delete(Long idx);

}
