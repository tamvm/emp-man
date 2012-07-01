/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import net.miginfocom.swing.MigLayout;
import util.Global;
import util.Util;

/**
 *
 * @author tamvo
 */
public abstract class AbstractPanel extends JPanel {

//  protected AbstractTableModel absTblModel;  
    
  public AbstractPanel() {
    initComponents();
  }

  public AbstractPanel(String title) {
    setBorder(BorderFactory.createTitledBorder(title));
    initComponents();
  }

  protected abstract void initComponents();

  protected JPanel getPanel(String title) {
    JPanel panel = new JPanel();

    if (!Util.isNOE(title)) {
      panel.setBorder(BorderFactory.createTitledBorder(title));
    }

    return panel;
  }

  protected JButton getImageButton(String imagePath, String text) {
    java.net.URL imgURL = Global.res.getClass().getResource(imagePath);
    System.out.println(imgURL.getPath());
    JButton button = new JButton(text, new ImageIcon(imgURL));
    return button;
  }

//  protected JScrollPane getTable(Object[] columns){
//      return new JScrollPane();
//  }
  
  protected JScrollPane getTable(AbstractTableModel absTblModel) {
    JTable table = new JTable();
    table.setModel(absTblModel);
    JScrollPane scrollPane = new JScrollPane(table);
    table.setFillsViewportHeight(true);
    return scrollPane;
  }
}
