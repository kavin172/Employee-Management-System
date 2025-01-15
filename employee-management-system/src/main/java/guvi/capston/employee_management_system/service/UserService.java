package guvi.capston.employee_management_system.service;


import guvi.capston.employee_management_system.dto.UserRegistrationDto;
import guvi.capston.employee_management_system.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
