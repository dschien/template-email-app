package ac.uk.bristol.cs.spe.templateemailapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EmailProvider emailProvider() {
        return new MicrosoftEmailProvider();
    }
}
