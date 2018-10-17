import java.util.*;

public class EmployeeService implements EmployeeDataService{
    private static EmployeeService es;
    private EmployeeService(){}
    public static EmployeeService getInstance(){
        if(es==null){
            es = new EmployeeService();
            return es;
        }
        else return es;
    }
    Map<Integer, Employee> empMapping = new HashMap<Integer, Employee>();
    public void addEmployee(int empId, String name, double salary){
        if(!empMapping.containsKey(empId)) {
            Employee emp = new Employee(empId, name, salary);
            empMapping.put(empId, emp);
        }
        else{
            System.out.println("user already exist");
        }
    }
    public void removeEmployee(int empId){
        Employee emp = empMapping.get(empId);
        if(emp!=null){
            empMapping.remove(empId);
            System.out.println("Employee removed");
        }
        else{
            System.out.println("EmpId doesn't exist");
        }
    }
    public void showEmployee(){
        Set<Integer> empRecord = empMapping.keySet();
        if(empRecord.size()==0){
            System.out.println("No employee in the record");
        }
        else {
            for (int i : empRecord) {
                Employee empDetails = empMapping.get(i);
                System.out.println(empDetails.getEmpid() + " " + empDetails.getName() + " " + empDetails.getSalary());
            }
        }
    }
    public void searchEmployee(String name){
        Set<Integer> empRecord = empMapping.keySet();
        if(empRecord.size()==0){
            System.out.println("No employee in the record");
        }
        else{
            for(int i:empRecord){
                Employee empDetails = empMapping.get(i);
                if(empDetails.getName().equals(name)){
                    System.out.println(empDetails.getEmpid()+" "+empDetails.getName()+" "+empDetails.getSalary());
                }
            }
        }
    }
    public void searchEmployeeBySalary(double a, double b){
        int flag = 0;
        Set<Integer> empRecord = empMapping.keySet();
        for(int i:empRecord){
            Employee empDetails = empMapping.get(i);
            if(empDetails.getSalary()>=a && empDetails.getSalary()<=b){
                System.out.println(empDetails.getEmpid()+" "+empDetails.getName()+" "+empDetails.getSalary());
                flag=1;
            }
        }
        if(flag==0) System.out.println("No Employee in salary range between a and b");
    }
}
