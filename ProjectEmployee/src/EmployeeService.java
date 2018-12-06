import java.util.List;

public interface EmployeeService{
	boolean addEmployee(int empId, String name, double salary);
	boolean removeEmployee(int empId);
	List<Employee> showEmployee();
	List<Employee> searchEmployeeByName(String name);
	List<Employee> searchEmployeeBySalary(double min, double max);
}
