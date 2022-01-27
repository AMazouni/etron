package fr.dosi.etron.exceptions;

import java.util.Map;

public class ResourcesNotFoundFault extends Throwable {

    Map<String,Object> body;
    String faultName = "ResourcesNotFoundFault";
    public ResourcesNotFoundFault(Object o, String reason) {
        body.put("reason",reason);
        body.put("input", o);
        body.put("message","No entity found");
        body.put("ExceptionType",faultName);
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResourcesNotFoundFault{" +
                "body=" + body +
                '}';
    }
}
