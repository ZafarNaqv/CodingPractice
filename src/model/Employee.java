package model;

import constants.EDepartment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private EDepartment department;
    
    public Employee(String name, EDepartment department) {
        this.name = name;
        this.department = department;
    }
    
    public String getName() {
        return name;
    }
    
    public EDepartment getDepartment() {
        return department;
    }
    
    public static void main(String[] args) {
        Employee hira = new Employee("Hira",EDepartment.HR);
        Employee beenish = new Employee("Beenish",EDepartment.SALES);
        Employee John = new Employee("John",EDepartment.SUPPORT);
        Employee zafar = new Employee("Zafar",EDepartment.IT);
        Employee asad = new Employee("Asad",EDepartment.DEVELOPMENT);
        Employee fawad = new Employee("Fawad",EDepartment.DEVELOPMENT);
        Employee Hasan = new Employee("Hasan",EDepartment.SALES);
        Employee ali = new Employee("Ali",EDepartment.DEVELOPMENT);
        Employee kubra = new Employee("Kubra",EDepartment.HR);
        List<Employee> employees = new ArrayList<>();
        employees.add(hira);
        employees.add(beenish);
        employees.add(John);
        employees.add(zafar);
        employees.add(asad);
        employees.add(fawad);
        employees.add(Hasan);
        employees.add(kubra);
        employees.add(ali);
        // System.out.println(getByDepartment(employees) );
        
        RetiredEmployee retiredEmployee = new RetiredEmployee("Horn",EDepartment.HR,150000,3);
        employees.add(retiredEmployee);
        
        List<RetiredEmployee> retiredEmployees = new ArrayList<>();
        retiredEmployees.add(retiredEmployee);
      //  printEmployeeNoGeneric(retiredEmployees);
        
    }
    
    public static Map<EDepartment, List<Employee>> getByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}