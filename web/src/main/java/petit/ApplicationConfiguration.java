package petit;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jerry.
 */

@Configuration
//@ComponentScan(basePackages = {"petit", "com.cowboysmall.insight"})
//@EnableAspectJAutoProxy
public class ApplicationConfiguration {

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }
}
