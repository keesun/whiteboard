package sandbox.profile.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Keesun Baik
 */
@Configuration
@Profile("korea")
public class KoreaConfig {

    @Bean
    public String toby(){
        return "이일민";
    }
}
