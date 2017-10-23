package ac.uk.bristol.cs.spe.templateemailapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(TemplateEmailAppApplication.class)
public class TemplateEmailIntegrationTests {

    @Autowired
    private MockMvc mvc;


    @Test
    public void basicPostRequest() throws Exception {
        mvc.perform(post("/sendemail")
                .contentType(MediaType.APPLICATION_JSON).content(
                        "{\"template\": \"The value is {0}\", \"recipientSubstitutions\": {\"daniel.schien@bristol.ac.uk\":[\"1\"]}}"
                )).andExpect(status().isCreated());
    }

}
