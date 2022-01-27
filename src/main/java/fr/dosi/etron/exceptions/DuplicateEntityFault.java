package fr.dosi.etron.exceptions;

import fr.dosi.etron.jpa.User;

public class DuplicateEntityFault extends Throwable {
    public DuplicateEntityFault(Object entity, String email) {
    }
}
