/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dataobject.CriteriaSearch;
import java.util.HashMap;
import java.util.Map;
import main.resources.Resource;
import ui.AbstractPanel;

/**
 * @author tamvo
 */
public class Global {

    public static Resource res = new Resource();
    public static Map<String, AbstractPanel> listComponents= new HashMap<String, AbstractPanel>();

    public static String getFieldName(CriteriaSearch type) {
        String name = "";
        if (type.equals(CriteriaSearch.FNAME)) {
            name = "first_name = ?";
        } else if (type.equals(CriteriaSearch.LNAME)) {
            name = "last_name = ?";
        } else if (type.equals(CriteriaSearch.NAME)) {
            name = "first_name = ? or last_name = ?";
        }
        return name;
    }
}
