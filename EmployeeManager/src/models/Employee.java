/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.javalite.activejdbc.Model;

/**
 *
 * @author tamvo
 */
public class Employee extends Model {
    public static String[] header = {"id", "first_name", "last_name", "position", "birth_date", "hire_date", "sex", "salary", "bonus"};
}
