/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author TRONG
 */

import ch.rakudave.suggest.JSuggestField;
import java.awt.Dimension;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class draft {
  public static void main(String[] args) {
    JTextField tf = new JTextField("mm");
    tf.setPreferredSize(tf.getPreferredSize());
    tf.setText("");

    
    
    JPanel pHacked = new JPanel();
    pHacked.add(tf);

    JPanel pStock = new JPanel();
    pStock.add(new JTextField(2));

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new java.awt.GridLayout(1, 1));
//    frame.add(pHacked);
//    frame.add(pStock);
    
    Vector<String> suggestData=new Vector<String>();
    suggestData.add("trong");
    suggestData.add("nguyen");
    suggestData.add("nguykhoi");
    JSuggestField s = new JSuggestField(frame, suggestData);
    s.setAutoscrolls(true);
    s.setPreferredSuggestSize(new Dimension(80, 20));
    s.setCaseSensitive(false);
    frame.add(s);
    frame.setSize(150, 150);
    frame.setVisible(true);
    tf.requestFocus();
    
  }
}