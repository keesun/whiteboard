package sandbox.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Keesun Baik
 */
public class BeforeAfterTests {

    @Before
    public void before(){
        System.out.println("before");
    }

    @Test
    public void test1(){

    }

    @Test
    public void test2(){

    }

    @After
    public void after(){
        System.out.println("after");
    }
}
