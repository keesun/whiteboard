package sandbox.testcontext;

import me.whiteship.board.modules.board.BoardService;
import me.whiteship.board.modules.post.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Keesun Baik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class WithTestContextTests {

    @Autowired BoardService boardService;
    @Autowired PostService postService;

    @Test public void test1(){

    }

    @Test public void test2(){

    }

}
