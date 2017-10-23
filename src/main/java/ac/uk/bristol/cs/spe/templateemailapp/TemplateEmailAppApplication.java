package ac.uk.bristol.cs.spe.templateemailapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class TemplateEmailAppApplication {


    private TemplateEmailService templateEmailService;

    public TemplateEmailAppApplication(TemplateEmailService templateEmailService) {
        this.templateEmailService = templateEmailService;
    }

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
