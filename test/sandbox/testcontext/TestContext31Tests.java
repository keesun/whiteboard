package sandbox.testcontext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sandbox.testcontext.config.AppConfig;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Keesun Baik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, locations = "/applicationContext.xml")
public class TestContext31Tests {

    @Resource String whiteship;
    @Resource String toby;

    @Test
    public void di(){
        assertThat(whiteship, is("keesun"));
        assertThat(toby, is("toby"));
    }

}
