package guvi.capston.employee_management_system.ExceptionHandler;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

