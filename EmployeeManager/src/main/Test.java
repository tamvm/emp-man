/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import models.Employee;
import org.javalite.activejdbc.Base;

/**
 *
 * @author tamvo
 */
public class Test {
    public static void main(String[] args) {

        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "");

        createEmp();

        selectAllEmp();
    }

    public static void createEmp() {
        Employee emp = new Employee();
        emp.set("first_name", "Tam");
        emp.set("last_name", "Vo");

        emp.saveIt();
    }

    public static void selectAllEmp() {
        List<Employee> listEmps = Employee.findAll();

        for (Employee emp : listEmps) {
            System.out.println(emp.get("first_name"));
        }
    }
}
