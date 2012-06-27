package com.devx.miglayout.swing.samples;

import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

/**
 * @author Jacek Furmankiewicz
 *
 */
public class GridBagLayoutSample extends AbstractSampleFrame {

	public GridBagLayoutSample() {
		super("MigLayout : GridBagLayout Sample");
	}

	@Override
	protected void initComponents() {
		
		MigLayout layout = new MigLayout("insets 0","[grow] 0 [grow] 0 [grow]","[] 0 [grow] 8 [grow]");
		setLayout(layout);
		
		//first row
		add(new JButton("Button 1"),"growx");
		add(new JButton("Button 2"),"growx");
		add(new JButton("Button 3"),"growx, wrap");
		
		//second row
		add(new JButton("Button 4"),"growx, span, top");
		
		//third row
		add(new JButton("Button 5"),"skip 1,growx, span 2, bottom");
		
		pack();
		
	}

}
