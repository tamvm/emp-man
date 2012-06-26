/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package activejdbcdemo;

import java.util.List;
import org.javalite.activejdbc.Base;

/**
 *
 * @author tamvo
 */
public class ActiveJdbc {

    public static void main(String[] args) {
        Base.open("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");

        List<Person> people = Person.where("name = 'John'");
        Person aJohn = people.get(0);
        String johnsLastName = (String) aJohn.get("last_name");
    }
}
