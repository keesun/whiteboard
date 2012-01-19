package sandbox.profile.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Keesun Baik
 */
@Configuration
public class AppConfig {

    @Bean
    public String whiteship(){
        return "Keesun";
    }

}
