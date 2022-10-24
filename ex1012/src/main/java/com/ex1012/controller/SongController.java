package com.ex1012.controller;

import com.ex1012.domain.Song;
import com.ex1012.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    private SongService songService;

    @Autowired
    public void setSongService(SongService songService) {
        this.songService = songService;
    }

    @RequestMapping("/add")
    public String add() {
        return "song/add";
    }

    @PostMapping("/add-save.do")
    public String addSave(
            @RequestParam("title") String title,
                @RequestParam("singer") String singer,
                @RequestParam("composer") String composer,
                @RequestParam("year") int year
    ) {

        Song song = new Song(title, singer, composer, year);

        songService.addSong(song);

        return "redirect:list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("song/list");

        List<Song> list = songService.getList();
        mv.addObject("list", list);

        return mv;
    }

    @GetMapping("/view/{idx}")
    public ModelAndView view(
            @PathVariable("idx") Long idx
    ) {
        ModelAndView mv = new ModelAndView("song/view");
        Song song = songService.read(idx);
        mv.addObject("song", song);

        return mv;
    }

    @GetMapping("/modify/{idx}")
    public ModelAndView modify(
            @PathVariable("idx") Long idx
    ) {
        ModelAndView mv = new ModelAndView("song/modify");

        Song song = songService.read(idx);
        mv.addObject("song", song);

        return mv;
    }

    @RequestMapping("/modify-save.do")
    public String modifySave(
            @RequestParam("idx") Long idx,
            @RequestParam("title") String title,
            @RequestParam("singer") String singer,
            @RequestParam("composer") String composer,
            @RequestParam("year") int year
    ) {
        Song song = new Song(title, singer, composer, year);

        songService.modify(idx, song);

        return "redirect:view/" + idx;
    }
    @RequestMapping("/delete.do/{idx}")
    public String deleteSave(
            @PathVariable("idx") Long idx
    ) {
        songService.delete(idx);

        return "redirect:../list";
    }

}
