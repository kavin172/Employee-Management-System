# Employee-Management-System

Introduction
The Employee Management System is a web-based application that enables seamless employee data management within an organization. The system allows administrators to perform CRUD operations on employee records, manage user accounts, assign roles, and handle user registration securely. Built using Spring Boot with Thymeleaf, it follows an MVC design pattern and integrates features like pagination, sorting, and user authentication.

Technology Stack
•	Backend: Spring Boot (Java)
•	Frontend: Thymeleaf (HTML, CSS, Bootstrap)
•	Database: H2 Database / MySQL
•	Security: Spring Security
•	API Documentation: SpringDoc OpenAPI / Swagger

Core Functionalities
1. Employee Management
•	Create, update, delete, and view employee records.
•	Search employees with pagination and sorting features.
•	View employee details on a user-friendly dashboard.
2. User Registration and Authentication
•	New users can register their accounts via a registration page.
•	Secure password storage using BCrypt hashing.
•	Role-based access management (e.g., admin or user).
3. Role Management
•	Users are assigned specific roles (ROLE_USER, ROLE_ADMIN).
•	Roles determine the accessibility and visibility of system features.
4. Pagination and Sorting
•	The application supports pagination for large data sets.
•	Data can be sorted dynamically by various fields (e.g., first name, last name).

Usage Instructions

1. Setup
•	Clone the project repository.
•	Configure the database in the application.properties file.
•	Run the application using an IDE or mvn spring-boot:run.
2. Access the Application
•	Open the browser and navigate to http://localhost:8080.
•	Use the registration page to create a new user or login with an existing account.
3. Managing Employees
•	Add, update, or delete employee records from the dashboard.
•	View paginated and sorted employee data.


![image](https://github.com/user-attachments/assets/69ffc89a-1968-4b0f-950a-7c4d601f9a81)

Controllers
EmployeeController
•	Endpoints:
o	GET / - Displays the list of employees with pagination and sorting.
o	GET /showNewEmployeeForm - Renders the form to add a new employee.
o	POST /saveEmployee - Saves a new employee.
o	GET /showFormForUpdate/{id} - Displays a pre-filled form to update an employee.
o	GET /deleteEmployee/{id} - Deletes an employee by ID.
o	GET /page/{pageNo} - Fetches paginated data with sorting parameters.
•	Thymeleaf Views:
o	index.html: Displays a list of employees.
o	new_employee.html: Form to add a new employee.
o	update_employee.html: Form to update existing employee details.
UserRegistrationController
•	Endpoints:
o	GET /registration - Renders the user registration form.
o	POST /registration - Handles new user registration.
•	Thymeleaf Views:
o	registration.html: Form for new user registration.


Swagger Api details

 GET / - Display the homepage with a paginated list of employees.
GET /showNewEmployeeForm - Display a form to add a new employee.
POST /saveEmployee - Save the new employee data.
GET /showFormForUpdate/{id} - Display a form for updating an employee's details.
GET /deleteEmployee/{id} - Delete an employee by their ID.
GET /page/{pageNo} - Fetch paginated employee data with sort functionality.
 GET /registration: Shows the registration form.
POST /registration: Handles the user registration by accepting user data and creating a new account. On successful registration, it redirects to the registration page with a success message (?success).

1. Employee Management
1.1 View All Employees
GET /
Description: Fetches a paginated and sorted list of employees.
•	Parameters:
o	pageNo (Query, Integer): The page number. Default: 1.
o	sortField (Query, String): Field to sort by. Default: firstName.
o	sortDir (Query, String): Sort direction (asc or desc). Default: asc.
•	Response:
o	200 OK: List of employees with pagination details.
o	Example:








JSON
CopyEdit
{
  "currentPage": 1,
  "totalPages": 5,
  "totalItems": 25,
  "listEmployees": [
    {
      "id": 1,
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com"
    },
    ...
  ]
}

1.2 Add a New Employee
GET /showNewEmployeeForm
Description: Displays the form for adding a new employee.
POST /saveEmployee
Description: Saves a new employee to the database.
•	Request Body:









JSON
CopyEdit
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com"
}
•	Response:
o	302 Redirect: Redirects to /.

1.3 Update Employee Details
GET /showFormForUpdate/{id}
Description: Displays the form to update employee details.
•	Path Parameter:
o	id (Long): ID of the employee to update.
•	Response:
o	200 OK: Returns the employee details for the given ID.

1.4 Delete an Employee
GET /deleteEmployee/{id}
Description: Deletes an employee by ID.
•	Path Parameter:
o	id (Long): ID of the employee to delete.
•	Response:
o	302 Redirect: Redirects to /.







2. User Registration
2.1 User Registration Form
GET /registration
Description: Displays the user registration form.
2.2 Register a User
POST /registration
Description: Registers a new user.
•	Request Body:
json
CopyEdit
{
  "firstName": "Jane",
  "lastName": "Doe",
  "email": "jane.doe@example.com",
  "password": "securePassword123"
}
•	Response:
o	302 Redirect: Redirects to /registration?success.

3. Pagination
GET /page/{pageNo}
Description: Fetches a paginated list of employees.
•	Path Parameter:
o	pageNo (Integer): Page number to retrieve.
•	Query Parameters:
o	sortField (String): Field to sort by. Default: firstName.
o	sortDir (String): Sort direction (asc or desc). Default: asc.
•	Response:
o	200 OK: Returns a list of employees with pagination and sorting details.


Schemas
 
1. Employee
Field	Type	Description
id	Long	Unique identifier for the employee.
firstName	String	First name of the employee.
lastName	String	Last name of the employee.
email	String	Email address of the employee.
2. User
Field	Type	Description
id	Long	Unique identifier for the user.
firstName	String	First name of the user.
lastName	String	Last name of the user.
email	String	Email address of the user.
password	String	User's password.
roles	Array	Collection of roles assigned to the user.
3. Role
Field	Type	Description
id	Long	Unique identifier for the role.
name	String	Name of the role (e.g., ROLE_USER).

Error Responses
•	404 Not Found: When an employee or user is not found.
o	Example:







JSON
CopyEdit
{
  "timestamp": "2025-01-26T12:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Employee not found for id :: 1",
  "path": "/showFormForUpdate/1"
}
•	400 Bad Request: For invalid input data.
•	500 Internal Server Error: For unexpected server issues.



