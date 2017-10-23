package ac.uk.bristol.cs.spe.templateemailapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateEmailServiceTest {


    @Autowired
    private EmailProvider emailProvider;

    @Autowired
    TemplateEmailService templateEmailService;


    @Test
    public void basicSubstitution() throws Exception {
        Map<String, List<String>> myMap = new HashMap<>();
        myMap.put("test@me.com", Collections.singletonList("1"));

        templateEmailService.sendTemplatedEmail("{0}", myMap);

        Map<String, String> results = ((MockEmailProvider) emailProvider).getResults();
        Assert.assertTrue(results.get("test@me.com").equals("[1]"));


    }

}
