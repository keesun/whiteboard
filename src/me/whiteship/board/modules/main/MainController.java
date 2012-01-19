package me.whiteship.board.modules.main;

import me.whiteship.board.domain.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Keesun Baik
 */
@Controller
public class MainController {

    @RequestMapping("/welcome")
    public @ResponseBody List<Board> boardList() {
        List<Board> boardList = new ArrayList<Board>();
        boardList.add(new Board("java"));
        boardList.add(new Board("spring"));
        return boardList;
    }

}
