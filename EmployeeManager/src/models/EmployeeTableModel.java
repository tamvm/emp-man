/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TRONG
 */
public class EmployeeTableModel extends AbstractTableModel {

    private List<Employee> empLst;
    private String[] header = {"ID", "F.Name", "L.Name", "Position", "B.Date", "Hire Date", "Sex", "Salary"};
    private String[] headerDB = {"id", "first_name", "last_name", "position", "birth_date", "hire_date", "sex", "salary", "bonus"};
    public EmployeeTableModel() {
//        this.empLst = empLst;
    }
    
    public void initData(List<Employee> empLst){
        this.empLst = empLst;
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet.");
        return empLst.size();
    }

    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet.");
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet.");
        return empLst.get(rowIndex).get(headerDB[columnIndex]);
    }
    
    @Override
    public String getColumnName(int index) {
        return header[index];
    }
 
//    public void add(String course, String grade) {
//        String[] str = new String[2];
//        str[0] = course;
//        str[1] = grade;
////        al.add(str);
//        fireTableDataChanged();
//    }

}
