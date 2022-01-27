package fr.dosi.etron.exceptions;

import fr.dosi.etron.jpa.User;

import java.util.HashMap;
import java.util.Map;

public class EmptyRessourceFault extends Throwable {

    String faultName ="EmptyRessourceFault";
    Map<String,Object> body;
    public EmptyRessourceFault(Object input, String reason) {
        body=new HashMap<String,Object>();
        body.put("reason",reason);
        body.put("input", input);
        body.put("ExceptionType",faultName);
    }

    @Override
    public String toString() {
        return "EmptyRessourceFault{" +
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

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
