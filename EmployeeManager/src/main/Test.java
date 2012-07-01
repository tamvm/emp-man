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
        getEmpl();
//        createEmp();

//        selectAllEmp();
    }

    public static void createEmp() {
        Employee emp = new Employee();
        emp.set("name", "Tam");
        emp.set("last_name", "Vo");
        emp.saveIt(); 
    }

//    public static void selectAllEmp() {
//        List<Employee> listEmps = Employee.findAll();
//
//        for (Employee emp : listEmps) {
//            System.out.println(emp.get("name"));
//        }
//    }
    
    public static void getEmpl(){
        List<Employee> e = Employee.findAll().offset(0).limit(10);
        for(Employee item: e){
            System.out.println("item: " + item.get("first_name") + " " +item.get("last_name"));
        }
    }
}
