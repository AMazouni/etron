package fr.dosi.etron.exceptions;

import fr.dosi.etron.jpa.User;

public class EmptyRessourceFault extends Throwable {
    public EmptyRessourceFault(Object entity) {
    }
}
