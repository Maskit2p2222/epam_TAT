package exceptions;

public class NotATriangleException extends Throwable {

    private String message;

    public NotATriangleException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
