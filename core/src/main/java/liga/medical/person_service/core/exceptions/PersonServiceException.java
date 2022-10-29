package liga.medical.person_service.core.exceptions;

public class PersonServiceException extends RuntimeException {
    public PersonServiceException() {
        super();
    }

    public PersonServiceException(String message) {
        super(message);
    }

    public PersonServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
