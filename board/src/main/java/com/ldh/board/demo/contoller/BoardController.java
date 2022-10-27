package com.ldh.board.demo.contoller;

import com.ldh.board.demo.domain.Board;
import com.ldh.board.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;

    @Autowired
    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/write")
    public String writePage() {
        return "board/write";
    }

    @PostMapping("/write.do")
    public String createBoard(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("author") String author
    ) {
        Board board = new Board(title, content, author);
        boardService.postBoard(board);

        return "redirect:list";
    }

    @GetMapping("/list")
    public ModelAndView listPage() {
        ModelAndView mv = new ModelAndView("board/list");
        List<Board> boardList = boardService.getBoards();
        mv.addObject("boardList", boardList);

        return mv;
    }

    @GetMapping("/view/{idx}")
    public ModelAndView viewPage(@PathVariable("idx") Long idx) {
        ModelAndView mv = new ModelAndView("/board/view");
        Board board = boardService.getBoard(idx);
        boardService.increaseWatchCount(idx);
        mv.addObject("board", board);
        return mv;
    }

    @GetMapping("/update/{idx}")
    public ModelAndView updatePage(@PathVariable("idx") Long idx) {
        ModelAndView mv= new ModelAndView("/board/update");
        Board board = boardService.getBoard(idx);
        mv.addObject("board", board);

        return mv;
    }

    @RequestMapping("/update.do")
    public String updateBoard(
            @RequestParam("idx") Long idx,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("author") String author
    ) {
        Board board = new Board(title, content, author);

        boardService.fetchBoard(idx, board);

        return "redirect:view/"+idx;
    }

    @RequestMapping("/delete.do/{idx}")
    public String deleteBoard(
            @PathVariable("idx") Long idx
    ) {
        boardService.deleteBoard(idx);
        return "redirect:../list";
    }



}
