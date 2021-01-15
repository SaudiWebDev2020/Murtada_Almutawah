package com.mamutawah.lookify.repositories;

import java.util.List;

import com.mamutawah.lookify.models.Song;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {

  // Get all songs
  List<Song> findAll();

  List<Song> findByArtistContaining(String query);

  @Query(value = "SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery = true)
  List<Song> top10Songs();
}
