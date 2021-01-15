package com.mamutawah.lookify.services;

import java.util.List;

import com.mamutawah.lookify.models.Song;
import com.mamutawah.lookify.repositories.SongRepository;

import org.springframework.stereotype.Service;

@Service
public class SongService {

  private final SongRepository songRepository;

  public SongService(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  // Get all
  public List<Song> getAll() {
    return songRepository.findAll();
  }

  // Create one !
  public Song create(Song song) {
    return songRepository.save(song);
  }

  // Get One
  public Song getOne(Long id) {
    return songRepository.findById(id).orElse(null);
  }

  // Remove
  public void delete(Long id) {
    songRepository.deleteById(id);
  }

  // searchByArtist
  public List<Song> searchByArtist(String artist) {
    return songRepository.findByArtistContaining(artist);
  }

  public List<Song> top10Songs() {
    return songRepository.top10Songs();
  }
}
