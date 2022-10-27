package com.ex1012.repository;


import com.ex1012.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<SongEntity, Long> {

    public List<SongEntity> findByTitle(String title);

    public List<SongEntity> findByYear(int year);

}
