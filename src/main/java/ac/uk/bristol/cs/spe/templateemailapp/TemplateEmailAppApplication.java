package ac.uk.bristol.cs.spe.templateemailapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
@PropertySources({
        @PropertySource(value = "file:${user.home}/.secret.properties", ignoreResourceNotFound = true)
})
public class TemplateEmailAppApplication {

    @Autowired
    private TemplateEmailService templateEmailService;

    @ResponseBody
    @RequestMapping(value = {"/sendemail"}, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    private String sendTemplatedEmail(@RequestBody TemplateEmailData templateEmailData) {
        templateEmailService.sendTemplatedEmail(templateEmailData.template, templateEmailData.recipientSubstitutions);
        return "{\"result\":\"completed\"}";
    }

    public static void main(String[] args) {
        SpringApplication.run(TemplateEmailAppApplication.class, args);
    }
}
