package es.nter.spring_cloud.exception;

public class EmailNotVAlidException extends RuntimeException {
    public EmailNotVAlidException(String message) {
        super(message);
    }
}
