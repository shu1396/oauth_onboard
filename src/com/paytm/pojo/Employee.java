package com.paytm.pojo;

import java.util.Objects;

public class Employee {
    private int empID;
    private String name;
    private double salary;
    public Employee(int empId, String name, double salary){
        this.empID = empId;
        this.name = name;
        this.salary = salary;
    }
    public void setEmpid(int empId){
        this.empID = empId;
    }
    public int getEmpid(){
        return empID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public double getSalary(){
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empID == employee.empID &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, name, salary);
    }
}
