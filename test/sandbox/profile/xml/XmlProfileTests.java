package sandbox.profile.xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Keesun Baik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ActiveProfiles("korea")
public class XmlProfileTests {

    @Resource String whiteship;
    @Resource String toby;

    @Test public void di(){
        assertThat(whiteship, is("Keesun"));
        assertThat(toby, is("이일민"));
    }
}