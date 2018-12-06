import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeServiceImpl es;
	private EmployeeServiceImpl() {};
	public static EmployeeServiceImpl getInstance() {
		if(es==null) {
			return new EmployeeServiceImpl();
		}
		else return es;
	}
	static Map<Integer, Employee> empMapping = new HashMap<Integer, Employee>();
	
	public boolean addEmployee(int empId, String name, double salary) {
		Employee emp = new Employee(empId, name, salary);
		if(empMapping.containsKey(empId)==false) {
			empMapping.put(empId, emp);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean removeEmployee(int empId) {
		if(!empMapping.containsKey(empId)) {
			return false;
		}
		else {
			empMapping.remove(empId);
			return true;
		}
	}
	public List<Employee> showEmployee() {
		List<Employee> empList = new ArrayList<Employee>();
		Set<Integer> empRecord = empMapping.keySet();	
		for (Integer i : empRecord) {
            Employee empDetails = empMapping.get((int)i);
            empList.add(empDetails);
		}
		return empList;
	}
	public List<Employee> searchEmployeeByName(String name){
		Set<Integer> empRecord = empMapping.keySet();
		List<Employee> empList = new ArrayList<Employee>();
        for(int i : empRecord) {
        	Employee empDetails = empMapping.get(i);
        	if(empDetails.getName().equals(name)==true) {
        		empList.add(empDetails);
        	}
        }
        return empList;
	}
	public List<Employee> searchEmployeeBySalary(double min, double max){
        Set<Integer> empRecord = empMapping.keySet();
        List<Employee> empList = new ArrayList<Employee>();
        for(int i:empRecord){
            Employee empDetails = empMapping.get(i);
            if(empDetails.getSalary()>=min && empDetails.getSalary()<=max){
            	empList.add(empDetails);
            }
        }
        return empList;
    }
}
