package sandbox.spring.test.mvc;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;

import static org.springframework.test.web.server.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.view;

/**
 * @author Keesun Baik
 */
public class WithTestMVCConfigSetupTests {

    static MockMvc mockMvc;

    @BeforeClass
    public static void beforeClass(){
        mockMvc = MockMvcBuilders.xmlConfigSetup("applicationContext.xml", "spring-servlet.xml")
                .webAppRootDir("/web", false)
                .build();
    }
    
    @Test
    public void boardList() throws Exception {
        mockMvc.perform(get("/board/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("/board/list"))
                .andDo(print());
    }

}
