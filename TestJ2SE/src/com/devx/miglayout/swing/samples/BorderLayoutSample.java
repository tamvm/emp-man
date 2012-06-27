package com.devx.miglayout.swing.samples;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JWindow;

import net.miginfocom.swing.MigLayout;

/**
 * @author Jacek Furmankiewicz
 *
 */
public class BorderLayoutSample extends AbstractSampleFrame {

	/**
	 * Constructor
	 */
	public BorderLayoutSample() {
		super("MigLayout : BorderLayout Sample");
	}
	
	@Override
	protected void initComponents() {
		MigLayout layout = new MigLayout();
		setLayout(layout);
		
		add(new JButton("Button 1 (PAGE_START)"),"dock north, width max");
		add(new JButton("Long named Button 4 (PAGE_END)"),"dock south, width max");
		add(new JButton("Button 3 (LINE_START)"),"dock west, height max");
		add(new JButton("Button 2 (CENTER)"),"dock center, width max, height max, grow");
		add(new JButton("Button 5 (LINE_END)"),"dock east, height max");
		
		setSize(600,400);
	}
}
