package ac.uk.bristol.cs.spe.templateemailapp;

import org.springframework.stereotype.Component;

/**
 * Created by csxds on 05/07/2017.
 */
@Component("microsoftEmailProvider")
public class MicrosoftEmailProvider implements EmailProvider {
    @Override
    public void sendEmail(String recipientEmail, String text) {
        throw new RuntimeException("Not implemented");
    }
}
