package me.whiteship.board.modules.board;

import me.whiteship.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author Keesun Baik
 */
@Controller
public class BoardController {

    @Autowired BoardService boardService;

    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/board/list")
    public String boardList(Model model){
        model.addAttribute("list", boardService.getAll());
        return "/board/list";
    }

    @RequestMapping(value = "/board/new", method = RequestMethod.GET)
    public String form(Model model) {
        model.addAttribute("board", new Board());
        return "/board/form";
    }

    @RequestMapping(value = "/board/new", method = RequestMethod.POST)
    public String formSubmit(@Valid Board board, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "/board/form";
        }
        boardService.add(board);
        return "redirect:/board/list";
    }

}
