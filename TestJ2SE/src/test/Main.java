/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;

/**
 *
 * @author eastagile
 */
public class Main {

    public static void main(String[] args) {
        List<Person> people = Person.where("name = 'John'");
        Person aJohn = people.get(0);
        String johnsLastName = (String) aJohn.get("last_name");
    }
}
