package fr.dosi.etron.exceptions;

import java.util.HashMap;
import java.util.Map;

public class DuplicateEntityFault extends Throwable {

     String faultName ="DuplicateEntityFault";
    Map<String,Object> body;
    public DuplicateEntityFault(Object input, String reason) {
        body=new HashMap<String,Object>();
        body.put("reason",reason);
        body.put("input", input);
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
        return "DuplicateEntityFault{" +
                "faultName='" + faultName + '\'' +
                ", body=" + body +
                '}';
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }
}
