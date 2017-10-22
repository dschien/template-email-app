package ac.uk.bristol.cs.spe.templateemailapp;

import org.springframework.stereotype.Component;

/**
 * Created by csxds on 05/07/2017.
 */
@Component
public class GmailEmailProvider implements EmailProvider {
    @Override
    public void sendEmail(String recipientEmail, String text) {

    }
}
