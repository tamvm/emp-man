/**
 *
 */
package com.devx.miglayout.swing;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.devx.miglayout.swing.samples.BorderLayoutSample;
import com.devx.miglayout.swing.samples.BoxLayoutSample1;
import com.devx.miglayout.swing.samples.BoxLayoutSample2;
import com.devx.miglayout.swing.samples.ComplexSample;
import com.devx.miglayout.swing.samples.GridBagLayoutSample;
import com.devx.miglayout.swing.samples.GridLayoutDemoSample;
import com.devx.miglayout.swing.samples.GroupLayoutSample;

import net.miginfocom.swing.MigLayout;

/**
 * @author Jacek Furmankiewicz
 *
 */
public class MainFrame extends JFrame {

  private JDesktopPane samplesFrame = new JDesktopPane();
  private JList list = new JList();

  /**
   * Constructor
   */
  public MainFrame(String title) {
    super(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setExtendedState(JFrame.MAXIMIZED_BOTH);

    MigLayout layout = new MigLayout();
    setLayout(layout);

    //list of samples

    list.setBorder(BorderFactory.createLoweredBevelBorder());
    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    DefaultListModel model = new DefaultListModel();
    model.add(0, new BorderLayoutSample());
    model.add(1, new BoxLayoutSample1());
    model.add(2, new BoxLayoutSample2());
    model.add(3, new GridBagLayoutSample());
    model.add(4, new GridLayoutDemoSample());
    model.add(5, new GroupLayoutSample());
    model.add(6, new ComplexSample());

    list.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseClicked(MouseEvent e) {
        JInternalFrame sample = (JInternalFrame) list.getSelectedValue();
        sample.setVisible(true);
        try {
          sample.setSelected(true);
        } catch (PropertyVetoException e1) {
        }
      }
    });

    list.setModel(model);

    add(list, "top, width 150, height max");

    //internal frame used for showing the samples
    samplesFrame.setVisible(true);
    add(samplesFrame, "width max, height max");

    //add all the sample frames to the desktop frame
    for (int i = 0; i < model.getSize(); i++) {
      JInternalFrame sample = (JInternalFrame) model.get(i);
      sample.setVisible(false);
      samplesFrame.add(sample);
    }
  }

  public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {

      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          //UIManager.setLookAndFeel(new SubstanceOfficeSilver2007LookAndFeel());
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        MainFrame frame = new MainFrame("MigLayout Samples");
        frame.setVisible(true);
      }
    });
  }
}
