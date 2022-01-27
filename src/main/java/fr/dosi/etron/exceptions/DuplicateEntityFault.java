package fr.dosi.etron.exceptions;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEntityFault extends Throwable {
    String reason;
    Object input;
    Map<String,Object> body;
    public DuplicateEntityFault(Object input, String reason) {
        this.reason=reason;
        this.input = input;
        body=new HashMap<String,Object>();
        body.put("reason",reason);
        body.put("input", input);
        body.put("message","Duplicated Entity");


    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public Object getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "DuplicateEntityFault{" +
                "reason='" + reason + '\'' +
                ", entity='" + input + '\'' +
                '}';
    }
}
