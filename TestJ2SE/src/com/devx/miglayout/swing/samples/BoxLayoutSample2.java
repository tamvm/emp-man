/**
 * 
 */
package com.devx.miglayout.swing.samples;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import net.miginfocom.swing.MigLayout;

/**
 * @author Jacek Furmankiewicz
 *
 */
public class BoxLayoutSample2 extends AbstractSampleFrame {

	/**
	 * @param title
	 */
	public BoxLayoutSample2() {
		super("MigLayout : BoxLayout Sample 2");
	}

	/* (non-Javadoc)
	 * @see com.devx.miglayout.samples.AbstractSampleFrame#initComponents()
	 */
	@Override
	protected void initComponents() {
		setLayout(new MigLayout("wrap 1",
				"[grow]",
				"[][grow][]"));

		add(new JLabel("Baby names ending in O:"));

		//list
		JList list = new JList();
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
		
		DefaultListModel model = new DefaultListModel();
		model.addElement("Arlo");
		model.addElement("Cosmo");
		model.addElement("Elmo");
		model.addElement("Hugo");
		model.addElement("Jethro");
		model.addElement("Laszlo");
		model.addElement("Milo");
		model.addElement("Nemo");
		model.addElement("Otto");
		model.addElement("Ringo");
		model.addElement("Rocco");
		model.addElement("Rollo");
		list.setModel(model);		
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setVisible(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane,"grow, height 200, width 400");
		
		//buttons
		add(new JButton("Cancel"),"split 2, right, sg buttons");
		add(new JButton("Set"),"sg buttons");
		
		pack();
	}

}
