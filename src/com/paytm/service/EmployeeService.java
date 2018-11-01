public interface EmployeeDataService {

    void addEmployee(int empId,String name,double salary);
    void removeEmployee(int empId);
    void showEmployee();
    void searchEmployee(String name);
    void searchEmployeeBySalary(double a, double b);
    void searchEmployeeSalaryByMonth(int empId, int month,int page);
}
