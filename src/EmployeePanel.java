import java.util.Scanner;

public class EmployeePanel {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        EmployeeService empService = EmployeeService.getInstance();
        while(true){
            System.out.println("Enter 1 to Add Employee");
            System.out.println("Enter 2 to remove Employee");
            System.out.println("Enter 3 to list the employees");
            System.out.println("Enter 4 to search Employee by name");
            System.out.println("Enter 5 to get employee name whose salary range from a to b");
            System.out.println("Enter 0 to exit");
            int choice = sc.nextInt();
            switch (choice){
                case 0 : System.exit(0);
                case 1 : {
                    System.out.println("Enter the empId, name and salary");
                    int empId = Integer.parseInt(sc.nextLine());
//                    sc.nextLine();
                    String name = sc.nextLine();
                    double salary = Double.parseDouble(sc.nextLine());
                    empService.addEmployee(empId,name,salary);
                    break;
                }
                case 2 : {
                    System.out.println("Enter ID to remove");
                    int empId = sc.nextInt();
                    empService.removeEmployee(empId);
                    break;
                }
                case 3: {
                    System.out.println("The employee Details: ");
                    empService.showEmployee();
                    break;
                }
                case 4: {
                    System.out.println("Enter employee name to retrieve details of employee");
                    sc.nextLine();
                    String name = sc.nextLine();
                    empService.searchEmployee(name);
                    break;
                }
                case 5:{
                    System.out.println("Enter a and b salary range");
                    System.out.println("a :");
                    double a = sc.nextDouble();
                    System.out.println("b :");
                    double b = sc.nextDouble();
                    empService.searchEmployeeBySalary(a,b);
                    break;
                }
                default:
                    System.out.println("Wrong Entry");
            }
        }
    }
}
