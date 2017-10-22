package ac.uk.bristol.cs.spe.templateemailapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by csxds on 05/07/2017.
 */
@Service
public class TemplateEmailService {

    @Qualifier("microsoftEmailProvider")
    private EmailProvider emailProvider;

    public TemplateEmailService(@Qualifier("microsoftEmailProvider") EmailProvider emailProvider) {
        this.emailProvider = emailProvider;
    }

    public void sendTemplatedEmail(String template, Map<String, List<String>> recipientSubstitutions) {
        for (String recipientEmail : recipientSubstitutions.keySet()) {
            emailProvider.sendEmail(recipientEmail, MessageFormat.format(template, recipientSubstitutions.get(recipientEmail)));
        }
    }
}


