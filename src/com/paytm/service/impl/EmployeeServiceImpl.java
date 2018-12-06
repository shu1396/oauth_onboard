package com.paytm.service.impl;

import com.paytm.pojo.Employee;
import com.paytm.service.EmployeeService;

import java.util.*;
import java.util.Date;
public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeServiceImpl es;
    private EmployeeServiceImpl(){}
    public static EmployeeServiceImpl getInstance(){
        if(es==null){
            es = new EmployeeServiceImpl();
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
            System.out.println("com.paytm.pojo.Employee removed");
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
/*            empMapping.forEach(empDetails->{
                if(empMapping.get(empDetails).equals(name)){
                    System.out.println(empDetails.getEmpid()+" "+empDetails.getName()+" "+empDetails.getSalary());
                }
            });*/
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
        if(flag==0) System.out.println("No com.paytm.pojo.Employee in salary range between a and b");
    }
    public void searchEmployeeSalaryByMonth(int empId, int month,int page) {
        Date d = new Date();
        Employee emp = empMapping.get(empId);
        int year = 2018;
        int serialNumber = 1;
        if (emp!= null) {
            int stop = 4;
            System.out.println(String.format("%128s", "").replace(' ', '-'));
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-21s|\n","S.No","Emp ID","Date","Working Days","Salary","Per Day Salary");
            while(stop--!=0){
                if(month<0){
                    year = year-1;
                    month = 12+month;
                }
                if(month>11){
                    year = year+1;
                    month = month - 12;
                }
                Calendar mycal = new GregorianCalendar(2018, month, 1);
                int daysInMonth = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
                System.out.printf("|%-20d|",serialNumber++);
                System.out.printf("%-20d|", emp.getEmpid());
                System.out.printf("1/%d/%-16d",month,year);
                System.out.printf("|%-20d",daysInMonth);
                System.out.printf("|%-20d",(int)emp.getSalary());
                System.out.printf("|%-21d|\n",(int)emp.getSalary()/daysInMonth);
                month--;
            }
            System.out.println(String.format("%128s", "").replace(' ', '-'));
        }
        else {
            System.out.println("EmpId doesn't exist");
        }
    }
}
