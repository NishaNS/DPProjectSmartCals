package edu.scu.dp.smartcals.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import edu.scu.dp.smartcals.exception.EmptyResultException;
import edu.scu.dp.smartcals.test.SmartCardTest;


/**
 * @author Nisha Narayanaswamy
 * 
 * VMClient class is the main view for the vending machine GUI. 
 *
 */

public class VMClient extends JFrame {

	private static JPanel pnlContainer;
	private static GridBagLayout gridLayout;
	private static GridBagConstraints gridConstraints;
	
	public VMClient(){

		pnlContainer = new JPanel();
		gridLayout = new GridBagLayout();
		gridConstraints = new GridBagConstraints();		
		
		
		createAndShowGUI();
		pnlContainer.setLayout(gridLayout);
		pnlContainer.setBackground(Color.CYAN);
		pnlContainer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
				Color.RED, Color.RED));
	


	}
	
	private void createAndShowGUI() {
		
		//start - Nisha - 8/15 - removed some lines
		this.setTitle("SmartCals Vending Machine");		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setContentPane(pnlContainer);			
		//end - Nisha - 8/15 
	}
	
	//start - Nisha - 8/15 - new method added 
	public void addPanels(JPanel pnlChild){
		pnlContainer.add(pnlChild);
		pnlChild.setVisible(true);
		pnlChild.requestFocusInWindow();
		this.setVisible(true);	
	}
	//end - Nisha - 8/15

}
