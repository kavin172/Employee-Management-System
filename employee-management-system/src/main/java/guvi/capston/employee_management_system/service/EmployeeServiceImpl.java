package guvi.capston.employee_management_system.service;

import guvi.capston.employee_management_system.ExceptionHandler.EmployeeNotFoundException;
import guvi.capston.employee_management_system.model.Employee;
import guvi.capston.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new EmployeeNotFoundException("Employee not found for id :: " + id);
		}
	}

	@Override
	public void deleteEmployeeById(long id) {
		if (employeeRepository.existsById(id)) {
			this.employeeRepository.deleteById(id);
		} else {
			throw new EmployeeNotFoundException("Employee not found for id :: " + id);
		}
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
				Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.employeeRepository.findAll(pageable);
	}
}
