package sandbox.spring.test.mvc;

import me.whiteship.board.domain.Board;
import me.whiteship.board.modules.board.BoardController;
import me.whiteship.board.modules.board.BoardService;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Keesun Baik
 */
public class WithoutTestMVCTests {

    @Test
    public void formSubmitSuccess(){
        BoardController controller = new BoardController();
        BoardService boardService = mock(BoardService.class);
        controller.setBoardService(boardService);

        Board board = new Board();
        board.setTitle("spring");

        BindingResult result = new BeanPropertyBindingResult(board, "board");

        Model model = new ExtendedModelMap();

        String viewName = controller.formSubmit(board, result, model);
        assertThat(viewName, is("redirect:/board/list"));
        verify(boardService).add(board);
    }

    @Test
    public void formSubmitFail(){
        BoardController controller = new BoardController();
        BoardService boardService = mock(BoardService.class);
        controller.setBoardService(boardService);

        Board board = new Board();

        BindingResult result = new BeanPropertyBindingResult(board, "board");
        result.rejectValue("title", "required", "input title please");

        Model model = new ExtendedModelMap();

        String viewName = controller.formSubmit(board, result, model);
        assertThat(viewName, is("/board/form"));
    }


}
