package ac.uk.bristol.cs.spe.templateemailapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class TemplateEmailAppApplication {

    @Autowired
    TemplateEmailService templateEmailService;

    @ResponseBody
    @RequestMapping(value = {"/sendemail"}, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    private String sendTemplatedEmail(@RequestBody TemplateEmailData templateEmailData) {
        templateEmailService.sendTemplatedEmail(templateEmailData.template, templateEmailData.recipientSubstitutions);
        return "completed";
    }

    public static void main(String[] args) {
        SpringApplication.run(TemplateEmailAppApplication.class, args);
    }
}
