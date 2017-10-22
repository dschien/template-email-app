package ac.uk.bristol.cs.spe.templateemailapp;

import java.util.List;
import java.util.Map;

class TemplateEmailData {

    String template;

    Map<String, List<String>> recipientSubstitutions;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Map<String, List<String>> getRecipientSubstitutions() {
        return recipientSubstitutions;
    }

    public void setRecipientSubstitutions(Map<String, List<String>> recipientSubstitutions) {
        this.recipientSubstitutions = recipientSubstitutions;
    }
}
