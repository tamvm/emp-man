/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import util.Config;

/**
 *
 * @author tamvo
 */
public class MainFrame extends JFrame {

  private JDesktopPane samplesFrame = new JDesktopPane();

  public MainFrame(String title) {
    super(title);

    setupForm();
  }

  private void setupForm() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1200, 800);
    //setExtendedState(JFrame.MAXIMIZED_BOTH);
    //pack();

    JPanel pnlMain = new JPanel();
    MigLayout layout = new MigLayout((Config.DEBUG && Config.BENCH_RUNS == 0 ? "debug, inset 15" : "ins 15"),
              "[]15[][grow,fill]15[grow]");//"[300!][700!]", "[shrink 0]"
    pnlMain.setLayout(layout);

    pnlMain.add(createLeftPanel(), "west");//
    pnlMain.add(createRightPanel(), "height max");

    add(pnlMain);

  }

  private JComponent createLeftPanel() {
    JPanel pnlLeft = new JPanel();
    pnlLeft.setLayout(new MigLayout("ins 5"));

    JTabbedPane tabbedPane = new JTabbedPane();
    JList listFuncs = new JList();
    listFuncs.setBorder(BorderFactory.createLoweredBevelBorder());
    listFuncs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listFuncs.setModel(createListModelForFunctionsPanel());

    JScrollPane scrollList = new JScrollPane(listFuncs);
    pnlLeft.add(scrollList, "top, width 290, height max");
    tabbedPane.add(pnlLeft, "Functions");

    return tabbedPane;
  }

  private DefaultListModel createListModelForFunctionsPanel() {
    DefaultListModel model = new DefaultListModel();
    model.add(0, new EmployeeListPanel());
    model.add(1, new ClientListPanel());

    return model;
  }

  private JComponent createRightPanel() {
    JPanel pnlRight = new JPanel();
    pnlRight.setLayout(new MigLayout("ins 5"));

    JTabbedPane tabbedPane = new JTabbedPane();
    pnlRight.add(new EmployeeListPanel());
    tabbedPane.add(pnlRight, "Employee");

    return tabbedPane;
  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {

      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          //UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());
        } catch (Exception e) {
          e.printStackTrace();
        }

        MainFrame frame = new MainFrame("MigLayout Samples");
        frame.setVisible(true);
      }
    });
  }
}
