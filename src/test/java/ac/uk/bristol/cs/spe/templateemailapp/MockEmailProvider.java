package ac.uk.bristol.cs.spe.templateemailapp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component(value = "mockEmailProvider")
public class MockEmailProvider implements EmailProvider {

    private Map<String, String> results;

    public MockEmailProvider() {
        this.results = new HashMap<>();
    }

    @Override
    public void sendEmail(String recipientEmail, String text) {
        results.put(recipientEmail, text);
    }

    public Map<String, String> getResults() {
        return this.results;
    }
}
