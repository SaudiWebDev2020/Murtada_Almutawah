package com.mamutawah.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import com.mamutawah.lookify.models.Song;
import com.mamutawah.lookify.services.SongService;

import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SongsController {

  private final SongService songService;

  public SongsController(SongService songService) {
    this.songService = songService;
  }

  @RequestMapping("/dashboard")
  public String dashboard(Model model) {
    List<Song> songs = songService.getAll();
    model.addAttribute("songs", songs);
    return "dashboard.jsp";
  }

  @RequestMapping("/songs/new")
  public String newSong(@ModelAttribute("song") Song song, Model model) {
    return "songs/new.jsp";
  }

  @RequestMapping("/songs/{id}")
  public String newSong(@PathVariable("id") Long id, Model model) {
    model.addAttribute("song", this.songService.getOne(id));
    return "songs/view.jsp";
  }

  @RequestMapping(value = "/songs", method = RequestMethod.POST)
  public String create(@Valid @ModelAttribute("song") Song song, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "songs/new.jsp";
    }
    songService.create(song);
    return "redirect:/dashboard";
  }

  @RequestMapping(value = "/songs/{id}", method = RequestMethod.DELETE)
  public String create(@PathVariable("id") Long id) {
    songService.delete(id);
    return "redirect:/dashboard";
  }

  @RequestMapping(value = "/search/")
  public String search(@RequestParam("artist") String artist, Model model) {
    model.addAttribute("searchedArtist", artist);
    model.addAttribute("songs", songService.searchByArtist(artist));
    return "search.jsp";
  }

  @RequestMapping(value = "/songs/top10")
  public String search(Model model) {
    model.addAttribute("songs", songService.top10Songs());
    return "songs/top10.jsp";
  }

}
