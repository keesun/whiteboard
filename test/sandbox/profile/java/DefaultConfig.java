package sandbox.profile.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Keesun Baik
 */
@Configuration
@Profile("default")
public class DefaultConfig {

    @Bean
    public String toby(){
        return "Toby";
    }

}
