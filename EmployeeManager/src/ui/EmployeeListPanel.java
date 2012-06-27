/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import net.miginfocom.swing.MigLayout;

/**
 *
 * @author tamvo
 */
public class EmployeeListPanel extends AbstractPanel {
  public EmployeeListPanel() {

  }

  protected void initComponents() {
    setLayout(new MigLayout("wrap 2", "[grow,800] []", "[grow,300]"));

    add(getTable("ID", "F.Name", "L.Name", "Position", "B.Date", "Hire Date", "Sex", "Salary"),
            "grow");
    add(getImageButton("img/list-add.png", "Add"), "sg 1, split 3, flowy, top");
    add(getImageButton("img/edit-redo.png", "Edit"), "sg 1");
    add(getImageButton("img/list-remove.png", "Delete"), "sg 1, wrap");
  }

  public String toString() {
    return "Employees";
  }
}
