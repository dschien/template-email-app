package ac.uk.bristol.cs.spe.templateemailapp;

/**
 * Created by csxds on 05/07/2017.
 */
public interface EmailProvider {
    void sendEmail(String recipientEmail, String text);
}
