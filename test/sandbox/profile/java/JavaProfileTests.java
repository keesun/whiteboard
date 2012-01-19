package sandbox.profile.java;

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
@ContextConfiguration(classes = {AppConfig.class, DefaultConfig.class, KoreaConfig.class})
@ActiveProfiles("korea")
public class JavaProfileTests {

    @Resource String toby;
    @Resource String whiteship;

    @Test
    public void di(){
        assertThat(whiteship, is("Keesun"));
        assertThat(toby, is("이일민"));

    }
}
