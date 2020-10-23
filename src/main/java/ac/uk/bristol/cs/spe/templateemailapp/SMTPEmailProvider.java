package ac.uk.bristol.cs.spe.templateemailapp;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by csxds on 05/07/2017.
 */
@Primary
@Component("SMTPEmailProvider")
public class SMTPEmailProvider implements EmailProvider {

    @Value("${smtpPort}")
    private String port;
    @Value("${smtpHost}")
    private String smtpHostName;
    @Value("${smtpUsername}")
    private String username;
    @Value("${smtpPassword}")
    private String password;
    @Value("${smtpFromEmail}")
    private String fromEmail;

    @Override
    public void sendEmail(String recipientEmail, String text) {
        Email email = new HtmlEmail();
        email.setHostName(smtpHostName);
        email.setSmtpPort(Integer.parseInt(port));
        email.setAuthenticator(new DefaultAuthenticator(username, password));
        email.setSSLOnConnect(true);
        try {
            email.setFrom(fromEmail);

            email.setSubject("Test Email");
            email.setMsg(text);
            email.addTo(recipientEmail);
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
