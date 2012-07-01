/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models.control;

import dataobject.CriteriaSearch;
import dataobject.EmployeeObj;
import java.util.List;
import models.Employee;
import org.javalite.activejdbc.Base;

/**
 *
 * @author TRONG
 */
public class EmployeeControl {

    public EmployeeControl() {
        if (!Base.hasConnection()) {
            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "");
        }
    }

    public void createEmployee(List<EmployeeObj> employeeLst) {
        Employee employee;
        for (EmployeeObj EmployeeItem : employeeLst) {
            employee = new Employee();
            employee.set("first_name", EmployeeItem.getFname());
            employee.set("last_name", EmployeeItem.getLname());
            employee.saveIt();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeLst = Employee.findAll();
        return employeeLst;
    }

    public List<Employee> getAllEmpPaging(int pageNum, int height) {
        List<Employee> empLst = Employee.findAll().offset(pageNum * height).limit(height);
        return empLst;
    }

    public List<Employee> getEmployeeByCriteria(CriteriaSearch type) {
        List<Employee> employeeLst = null;

        return employeeLst;
    }

    public void deleteAllEmployees() {
        Employee.deleteAll();
    }

    public void deleteEmployee(Employee employee) {
        employee.delete();
    }
}
