import com.paytm.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeePanel {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        EmployeeServiceImpl empService = EmployeeServiceImpl.getInstance();
        while(true){
            System.out.println("Enter 1 to Add com.paytm.pojo.Employee");
            System.out.println("Enter 2 to remove com.paytm.pojo.Employee");
            System.out.println("Enter 3 to list the employees");
            System.out.println("Enter 4 to search com.paytm.pojo.Employee by name");
            System.out.println("Enter 5 to get employee name whose salary range from a to b");
            System.out.println("Enter 6 to get com.paytm.pojo.Employee Salary Slip");
            System.out.println("Enter 0 to exit");
            int choice = sc.nextInt();
            switch (choice){
                case 0 : System.exit(0);
                case 1 : {
                    System.out.println("Enter the empId, name and salary");
                    /*int empId = sc.nextInt();
                    sc.nextLine();
                    String name = sc.nextLine();
                    double salary = sc.nextDouble();*/
                    empService.addEmployee(1001,"shubham",123456);
                    empService.addEmployee(1002,"qwerty",678657);
                    empService.addEmployee(1003,"point",90000);
                    empService.addEmployee(1004,"tipping", 70000);
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
                case 6: {
                    int page = 1;
                    System.out.println("Enter employee Id");
                    int id = sc.nextInt();
                    int month = 9;
                    empService.searchEmployeeSalaryByMonth(id,month,page);
                    while(true) {
                        System.out.println("Enter your choice: N for NextPage , P for Previous Page and E for ending the Search");
                        String pageCase = sc.next();
                        int flag = 0;
                        switch (pageCase) {
                            case "N":
                            case "n":
                                month = month - 4;
                                page++;
                                empService.searchEmployeeSalaryByMonth(id, month, page);
                                break;
                            case "p":
                            case "P":
                                if(page<=1) {
                                    System.out.println("Previous Page not allowed");
                                    break;
                                }
                                month = month + 4;
                                page--;
                                empService.searchEmployeeSalaryByMonth(id, month, page);
                                break;
                            case "E":
                            case "e":
                                flag = 1;
                                break;
                        }
                        if (flag == 1) break;
                    }
                    break;
                }
                default:
                    System.out.println("Wrong Entry");
            }
        }
    }
}