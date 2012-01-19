package sandbox.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Keesun Baik
 */
public class BeforeAfterClassTests {
    
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before");
    }

    @Test
    public void test1(){

    }

    @Test
    public void test2(){

    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After");
    }
}
