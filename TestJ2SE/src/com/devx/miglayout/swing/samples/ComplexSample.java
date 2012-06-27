package com.devx.miglayout.swing.samples;

import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * Complex MigLayout sample
 *
 * @author Jacek Furmankiewicz
 */
public class ComplexSample extends AbstractSampleFrame {

  public ComplexSample() {
    super("MigLayout : Complex UI sample");
  }

  protected void initComponents() {
    MigLayout layout = new MigLayout("wrap 3", "[] [grow] []", "[] [grow] [grow] [grow] []");
    setLayout(layout);

    //put all the panels together
    add(getClientPanel(), "grow");
    add(getInformationPanel(), "grow");
    add(getAdditionalInformationPanel(), "grow");

    add(getProductListPanel(), "grow, span 3");
    add(getTasksPanel(), "grow, span 3");
    add(getCommentsPanel(), "grow, span 3");
    add(getButtonsPanel(), "grow, span 3");

    pack();
  }

  private JPanel getClientPanel() {
    JPanel panel = getPanel("Client");
    panel.setLayout(new MigLayout("wrap 2", "[] 16 []"));

    panel.add(new JLabel("Client ID:"), "right");
    panel.add(new JLabel("#43354"));

    panel.add(new JLabel("Name:"), "right");
    panel.add(new JLabel("John Smith"));

    panel.add(new JLabel("Phone:"), "right");
    panel.add(new JLabel("(514) 999-9999"));

    panel.add(new JLabel("Fax:"), "right");
    panel.add(new JLabel("(514) 888-8888"));

    panel.add(new JLabel("Registration #:"), "right");
    panel.add(new JLabel("#4534-AAC-324"));

    panel.add(new JLabel("Website:"), "right");
    panel.add(new JLabel("devx.com"));

    panel.add(new JButton("Details..."));

    return panel;

  }

  private JPanel getInformationPanel() {
    JPanel panel = getPanel("Information");
    panel.setLayout(new MigLayout("wrap 3", "[] 16 [grow] []"));

    panel.add(new JLabel("Reserve days:"), "right");
    JTextField field1 = new JTextField("0 of 0");
    field1.setEditable(false);
    panel.add(field1, "grow");
    panel.add(new JButton("Add Days..."));

    panel.add(new JLabel("Buyer:"), "right");
    panel.add(new JTextField("Wal-Mart"), "span, growx");

    panel.add(new JLabel("Seller:"), "right");
    panel.add(new JTextField("China, Inc."), "span, growx");

    panel.add(new JLabel("Address:"), "right");
    panel.add(new JTextField("123 Mao Street, Beijing"), "span, growx");

    panel.add(new JLabel("Credit rating:"), "right");
    panel.add(new JTextField("AAA"), "growx");
    panel.add(new JButton("S&P Update.."));

    panel.add(new JCheckBox("Approved", true));
    panel.add(new JTextField("Tony Soprano gave us an offer we couldn't refuse"), "span, growx");

    return panel;
  }

  private JPanel getAdditionalInformationPanel() {
    JPanel panel = getPanel("Additional information");
    panel.setLayout(new MigLayout("wrap 4", "[] 16 [grow][] []"));

    panel.add(new JLabel("Estimated close:"), "right");
    panel.add(new JTextField("Real soon now..."), "span 2");
    panel.add(getImageButton("images/edit-redo.png", "Edit"), "top");
    //panel.add(new JButton("test"));

    panel.add(new JLabel("Creation date:"), "right");
    panel.add(new JLabel("01-01-1970"), "wrap");

    panel.add(new JLabel("Created by:"), "right");
    panel.add(new JLabel("Big Tony"), "wrap");

    panel.add(new JLabel("Last edit date:"), "right");
    panel.add(new JLabel("05-13-1989"), "wrap");

    panel.add(new JLabel("Last edited by:"), "right");
    panel.add(new JLabel("Big Tony"), "wrap");

    panel.add(new JLabel("Closed date:"), "right");
    panel.add(new JLabel(""), "wrap");

    panel.add(new JLabel("Closed by:"), "right");
    panel.add(new JLabel(""), "wrap");

    return panel;
  }

  private JPanel getProductListPanel() {
    JPanel panel = getPanel("Product List");
    panel.setLayout(new MigLayout("wrap 4", "[grow] 16 [] 32 [] []", "[grow,:100:] [] [] []"));

    panel.add(getTable("Renovation", "Description", "Part #", "Quantity", "List Price", "Discount", "Price",
            "Wholesaler Discount", "Wholesaler Price"),
            "grow, span 3");
    panel.add(getImageButton("images/list-add.png", "Add"), "split 3, flowy, sg 1, top");
    panel.add(getImageButton("images/edit-redo.png", "Edit"), "sg 1");
    panel.add(getImageButton("images/list-remove.png", "Delete"), "sg 1, wrap");

    panel.add(new JSeparator(), "growx");
    panel.add(new JLabel("Subtotal list price:"));
    panel.add(new JLabel("$0.00"), "right, wrap");

    panel.add(new JLabel("Total retailer price:"), "skip 1");
    panel.add(new JLabel("$0.00"), "right, wrap");

    panel.add(new JLabel("Total wholesaler price:"), "skip 1");
    panel.add(new JLabel("$0.00"), "right");

    return panel;
  }

  private JPanel getTasksPanel() {
    JPanel panel = getPanel("Tasks");
    panel.setLayout(new MigLayout("wrap 2", "[grow] []", "[grow,:100:]"));

    panel.add(getTable("State", "Task", "Assigner", "Executer", "Creation Date", "Estimated Date", "Executed Date"),
            "grow");
    panel.add(getImageButton("images/list-add.png", "Add"), "sg 1, split 3, flowy, top");
    panel.add(getImageButton("images/edit-redo.png", "Edit"), "sg 1");
    panel.add(getImageButton("images/list-remove.png", "Delete"), "sg 1, wrap");

    return panel;
  }

  private JPanel getCommentsPanel() {
    JPanel panel = getPanel("Comments");
    panel.setLayout(new MigLayout("wrap 2", "[grow] []", "[grow,:100:]"));

    panel.add(getTable("Date", "User", "Comment"),
            "grow");
    panel.add(getImageButton("images/list-add.png", "Add"), "sg 1, split 3, flowy, top");
    panel.add(getImageButton("images/edit-redo.png", "Edit"), "sg 1");
    panel.add(getImageButton("images/list-remove.png", "Delete"), "sg 1, wrap");

    return panel;
  }

  private JPanel getButtonsPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new MigLayout("", "[] [grow, right]"));

    panel.add(new JButton("Export"), "sg 1");
    panel.add(getImageButton("images/document-save.png", "Save"), "split 2, sg 1");
    panel.add(getImageButton("images/system-log-out.png", "Cancel"), "sg 1");

    return panel;
  }

  private JPanel getPanel(String title) {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createTitledBorder(title));
    return panel;
  }

  private JButton getImageButton(String imagePath, String text) {
    java.net.URL imgURL = getClass().getResource(imagePath);
    JButton button = new JButton(text, new ImageIcon(imgURL));
    return button;
  }

  private JScrollPane getTable(Object... columns) {
    JTable table = new JTable(new Object[0][0], columns);
    JScrollPane scrollPane = new JScrollPane(table);
    table.setFillsViewportHeight(true);
    return scrollPane;
  }
}
