/**
 * 
 */
package com.devx.miglayout.swing.samples;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

/**
 * @author Jacek Furmankiewicz
 */
public class GroupLayoutSample extends AbstractSampleFrame {

	public GroupLayoutSample() {
		super("MigLayout : GroupLayout sample");
	}

	/* (non-Javadoc)
	 * @see com.devx.miglayout.samples.AbstractSampleFrame#initComponents()
	 */
	@Override
	protected void initComponents() {
		MigLayout layout = new MigLayout("","[] [] [grow] []","[baseline]");
		setLayout(layout);
		
		add(new JLabel("Find What:"));
		add(new JTextField(),"growx, span 2");
		
		add(new JButton("Find"),"span 1 3, split 2, top, growx, flowy");
		add(new JButton("Cancel"),"growx, wrap");

		add(new JCheckBox("Match Case"),"skip 1, sg 1");
		add(new JCheckBox("Wrap Around"),"sg 1, wrap");
		
		add(new JCheckBox("Whole Words"),"skip 1, sg 1, left");
		add(new JCheckBox("Search Backwards"),"sg 1, left, wrap");
		
		pack();
	}

}
