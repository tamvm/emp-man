package main;

import javax.swing.JFrame;
import javax.swing.UIManager;
import ui.MainFrame;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author tamvo
 */
public class Main {

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
