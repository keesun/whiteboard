package sandbox.testcontext;

import me.whiteship.board.modules.board.BoardService;
import me.whiteship.board.modules.post.PostService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Keesun Baik
 */
public class WithoutTestContextTests {

    static ApplicationContext applicationContext;

    @BeforeClass
    public static void before(){
        applicationContext = new GenericXmlApplicationContext("classpath:/applicationContext.xml");
    }

    @Test
    public void boardServiceTest(){
        BoardService boardService = applicationContext.getBean(BoardService.class);
        assertThat(boardService, is(notNullValue()));

        //test
    }

    @Test
    public void postServiceTest(){
        PostService postService = applicationContext.getBean(PostService.class);
        assertThat(postService, is(notNullValue()));

        //test
    }

}
