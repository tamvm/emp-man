package miglayout;


import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;

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
        JPanel parentContainer = new JPanel(new MigLayout("fillx,insets 1"));
        JPanel component1 = new JPanel();
        component1.setBackground(Color.GRAY);
        parentContainer.add(component1, "width :100:");

        JPanel component2 = new JPanel();
        component2.setBackground(Color.GRAY);
        parentContainer.add(component2, "width :100:");

        JPanel component3 = new JPanel();
        component3.setBackground(Color.GRAY);
        parentContainer.add(component3, "width :100:");
        
        JFrame mainFrame = new JFrame("Testing");
        mainFrame.add(parentContainer);
        mainFrame.setSize(600, 800);
        mainFrame.setVisible(true);
    }
}
