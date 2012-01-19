package me.whiteship.board.modules.main;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.result.PrintingResultHandler;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import java.util.regex.Matcher;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;

/**
 * @author Keesun Baik
 */
public class MainControllerTest {

    @Test
    public void testBoardList() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new MainController())
                .build();

        mockMvc.perform(get("/welcome").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().type(MediaType.APPLICATION_JSON))
                .andExpect(content().string(Matchers.containsString("spring")))
                .andDo(new PrintingResultHandler(System.out));
    }

}
