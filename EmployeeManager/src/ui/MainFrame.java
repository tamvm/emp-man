/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import util.Config;
import util.Global;

/**
 *
 * @author tamvo
 */
public class MainFrame extends JFrame {

    private JDesktopPane samplesFrame = new JDesktopPane();
    private JTabbedPane tabbedPane;
    private String selectedComponent;

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
        listFuncs.setSelectedIndex(0);
        selectedComponent = listFuncs.getSelectedValue().toString();
        listFuncs.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                selectedComponent = list.getSelectedValue().toString();
                updateRightPanel();
            }
        });

        JScrollPane scrollList = new JScrollPane(listFuncs);
        pnlLeft.add(scrollList, "top, width 290, height max");
        tabbedPane.add(pnlLeft, "Functions");

        return tabbedPane;
    }

    private DefaultListModel createListModelForFunctionsPanel() {
        DefaultListModel model = new DefaultListModel();
        EmployeeListPanel empPanel = new EmployeeListPanel();
        ClientListPanel clientPanel = new ClientListPanel();
        model.add(0, empPanel);
        model.add(1, clientPanel);
        // init static components: emp, client
        Global.listComponents.put("Employees", empPanel);
        Global.listComponents.put("Clients", clientPanel);
        return model;
    }

    private JComponent createRightPanel() {
        JPanel pnlRight = new JPanel();
        pnlRight.setLayout(new MigLayout("ins 5"));
        tabbedPane = new JTabbedPane();
        pnlRight.add(Global.listComponents.get(selectedComponent));
        tabbedPane.add(pnlRight);
        setTitleTab();
        return tabbedPane;
    }

    private void setTitleTab() {
        if (selectedComponent.equals("Employees")) {
            tabbedPane.setTitleAt(0, "Employee");
        } else if (selectedComponent.equals("Clients")) {
            tabbedPane.setTitleAt(0, "Client");
        }
    }

    public void updateRightPanel() {
        JPanel pnlRight = (JPanel) tabbedPane.getComponentAt(0);
        pnlRight.removeAll();
        pnlRight.add(Global.listComponents.get(selectedComponent));
        pnlRight.updateUI();
        setTitleTab();
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
