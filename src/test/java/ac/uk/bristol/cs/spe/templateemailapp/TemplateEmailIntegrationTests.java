package ac.uk.bristol.cs.spe.templateemailapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TemplateEmailIntegrationTests {

    private MockMvc mvc;

    @Autowired
    TemplateEmailAppApplication templateEmailAppApplication;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.standaloneSetup(templateEmailAppApplication).build();
    }

    @Test
    public void basicPostRequest() throws Exception {
        mvc.perform(post("/sendemail")
                .contentType(MediaType.APPLICATION_JSON).content(
                        "{\"template\": \"The value is {0}\", \"recipientSubstitutions\": {\"test@me.com\":[\"1\"]}}"
                )).andExpect(status().isOk());
    }

}
