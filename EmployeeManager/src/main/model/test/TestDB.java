/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model.test;

import models.Employee;
import org.javalite.activejdbc.Base;

/**
 *
 * @author TRONG
 */
public class TestDB {
    public void main(String[] args){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/test", "root", "");
        Employee.findAll().dump();
        Base.close();
    }
}
