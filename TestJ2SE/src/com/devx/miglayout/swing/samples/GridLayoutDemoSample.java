/**
 * 
 */
package com.devx.miglayout.swing.samples;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * @author Jacek Furmankiewicz
 *
 */
public class GridLayoutDemoSample extends AbstractSampleFrame {

	public GridLayoutDemoSample() {
		super("MigLayout : GridLayout Sample");
	}

	/* (non-Javadoc)
	 * @see com.devx.miglayout.samples.AbstractSampleFrame#initComponents()
	 */
	@Override
	protected void initComponents() {
			
		MigLayout layout = new MigLayout("insets 0, gap 0, wrap 1","[grow]","[grow] 4 []");
		setLayout(layout);
		
		//top panel - just a grid
		final String baseConstraints = "insets 0,gap 0, wrap 2, fill";
		final MigLayout topLayout = new MigLayout(baseConstraints);
		final JPanel top = new JPanel();
		top.setLayout(topLayout);
		top.add(new JButton("Button 1"),"grow");
		top.add(new JButton("Button 2"),"grow");
		top.add(new JButton("Button 3"),"grow");
		top.add(new JButton("Button 4"),"grow");
		top.add(new JButton("Button 5"),"grow");

		//bottom
		MigLayout bottomLayout = new MigLayout("insets 0, gap 0, wrap 3, fillx, bottom");
		JPanel bottom = new JPanel();
		bottom.setLayout(bottomLayout);
		bottom.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		
		bottom.add(new JLabel("Horizontal gap:"));
		bottom.add(new JLabel("Vertical gap:"),"wrap");
		
		final JComboBox hgapCombo = new JComboBox(new Object[]{0,4,8,16,20,24});
		bottom.add(hgapCombo,"growx, sg 1");
		final JComboBox vgapCombo = new JComboBox(new Object[]{0,4,8,16,20,24});
		bottom.add(vgapCombo,"growx, sg 1");
		
		JButton button = new JButton("Apply gaps");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer hgap = (Integer)hgapCombo.getSelectedItem();
				Integer vgap = (Integer)vgapCombo.getSelectedItem();
				topLayout.setLayoutConstraints(String.format("%s, gap %spx %spx", baseConstraints, hgap, vgap));
				top.invalidate();
				pack();
			}
		});
		bottom.add(button,"growx, sg 1");

		//put it all together
		add(top,"grow");
		add(bottom,"growx, bottom");
		
		pack();
		
	}

}
