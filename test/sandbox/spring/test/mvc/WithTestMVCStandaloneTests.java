package sandbox.spring.test.mvc;

import me.whiteship.board.domain.Board;
import me.whiteship.board.modules.board.BoardController;
import me.whiteship.board.modules.board.BoardService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Matchers;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.result.PrintingResultHandler;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;

/**
 * @author Keesun Baik
 */
public class WithTestMVCStandaloneTests {

    static MockMvc mockMvc;
    static BoardService boardService;

    @BeforeClass
    public static void beforClass(){
        BoardController controller = new BoardController();
        boardService = mock(BoardService.class);
        controller.setBoardService(boardService);

        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views");
        internalResourceViewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(internalResourceViewResolver)
                .build();
    }

    @Before
    public void before(){
        reset(boardService);
    }

    @Test
    public void formSubmitSuccess() throws Exception {
        mockMvc.perform(post("/board/new").param("title", "spring"))
            .andExpect(status().isOk())
            .andExpect(view().name("redirect:/board/list"));

        verify(boardService, times(1)).add(Matchers.<Board>any());
    }

    @Test
    public void formSubmitFailure() throws Exception {
        mockMvc.perform(post("/board/new"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/board/form"));

        verify(boardService, times(0)).add(Matchers.<Board>any());
    }
    
    @Test
    public void getList() throws Exception {
        List<Board> fixtureBoards = new ArrayList<Board>();
        Board board = new Board();
        board.setTitle("Spring");

        when(boardService.getAll()).thenReturn(fixtureBoards);
        
        mockMvc.perform(get("/board/list"))
                .andExpect(status().isOk())
                .andExpect(handler().type(BoardController.class))
                .andExpect(handler().methodName("boardList"))
                .andExpect(model().size(1))
                .andExpect(model().attributeExists("list"))
                .andExpect(model().attribute("list", fixtureBoards))
                .andExpect(view().name("/board/list"))
                .andExpect(forwardedUrl("/WEB-INF/views/board/list.jsp"))
                .andDo(print());
        
    }

}
