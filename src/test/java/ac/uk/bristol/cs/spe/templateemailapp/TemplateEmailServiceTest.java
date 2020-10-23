package ac.uk.bristol.cs.spe.templateemailapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateEmailServiceTest {

    @Configuration
    static class ContextConfiguration {

        // this bean will be injected into the OrderServiceTest class
        @Bean
        public EmailProvider emailProviderService() {
            EmailProvider mockEmailProvider = new MockEmailProvider();
            return mockEmailProvider;
        }

        @Bean
        public TemplateEmailService templateEmailService() {
            return new TemplateEmailService();
        }

    }


    @Autowired
    private EmailProvider mockEmailProvider;

    @Autowired
    TemplateEmailService templateEmailService;


    @Test
    public void basicSubstitution() throws Exception {
        Map<String, List<String>> myMap = new HashMap<>();
        myMap.put("test@me.com", Collections.singletonList("1"));

        templateEmailService.sendTemplatedEmail("{0}", myMap);

        Map<String, String> results = ((MockEmailProvider) mockEmailProvider).getResults();
        Assert.assertTrue(results.get("test@me.com").equals("[1]"));

    }

}
