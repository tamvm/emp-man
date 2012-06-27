/**
 * 
 */
package com.devx.miglayout.swing.samples;

import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

/**
 * @author Jacek Furmankiewicz
 *
 */
public class BoxLayoutSample1 extends AbstractSampleFrame {

	public BoxLayoutSample1() {
		super("MigLayout : BoxLayout Sample 1");
	}

	/* (non-Javadoc)
	 * @see com.devx.miglayout.samples.AbstractSampleFrame#initComponents()
	 */
	@Override
	protected void initComponents() {
		setLayout(new MigLayout("wrap 1, center"));
		
		add(new JButton("Button 1"),"center");
		add(new JButton("Button 2"),"center");
		add(new JButton("Button 3"),"center");
		add(new JButton("Long-Named Button 4"),"center");
		add(new JButton("5"),"center");
		
		pack();

	}

}
