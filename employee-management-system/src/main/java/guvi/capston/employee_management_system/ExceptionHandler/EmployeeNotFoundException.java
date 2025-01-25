package guvi.capston.employee_management_system.ExceptionHandler;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

