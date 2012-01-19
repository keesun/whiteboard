package sandbox.junit;

import org.junit.Test;

/**
 * @author Keesun Baik
 */
public class SampleJUnitTests {

    private int i = 1;

    @Test
    public void test1(){
        i++;
        System.out.println(i);
    }

    @Test
    public void test2(){
        i++;
        System.out.println(i);
    }

}
