/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import models.Employee;
import models.EmployeeTableModel;
import models.control.EmployeeControl;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author tamvo
 */
public class EmployeeListPanel extends AbstractPanel {

    private List<Employee> empList;
    private JScrollPane scrollPane;
    private JTable tblEmp;
    private EmployeeTableModel absTblModel;
    private EmployeeControl ctrlEmp;

    public EmployeeListPanel() {
    }

    protected void initComponents() {
        setLayout(new MigLayout("wrap 2", "[grow,800] []", "[grow,300]"));
        ctrlEmp = new EmployeeControl();
        initTable();
        
        add(scrollPane, "grow");
        add(getImageButton("img/list-add.png", "Add"), "sg 1, split 3, flowy, top");
        add(getImageButton("img/edit-redo.png", "Edit"), "sg 1");
        add(getImageButton("img/list-remove.png", "Delete"), "sg 1, wrap");
    }

    private void initTable() {
        absTblModel = new EmployeeTableModel();
        absTblModel.initData(ctrlEmp.getAllEmpPaging(0, 10));
        scrollPane = getTable(absTblModel);
        tblEmp = (JTable) ((JViewport) scrollPane.getComponent(0)).getComponent(0);
        
    }

    // use for paging table
    public void dataChanged(List<Employee> empLst) {
        absTblModel.initData(empLst);
        tblEmp.setModel(absTblModel);
    }

    public String toString() {
        return "Employees";
    }
}
