package edu.scu.dp.smartcals.ui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


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
	private static VMDetails_View sectionDetails;
	private static JPanel sectionProdCatgeory;
	private static JPanel sectionProdSelect;	//** placeholder code


	public VMClient(){

		pnlContainer = new JPanel();
		gridLayout = new GridBagLayout();
		gridConstraints = new GridBagConstraints();		
		sectionDetails = new VMDetails_View();
		sectionProdCatgeory = new JPanel();		//** placeholder code
		sectionProdSelect = new JPanel(); //** placeholder code
		pnlContainer.setLayout(gridLayout);

	}


	private static void createAndShowGUI() {

		VMClient vendingMachine = new VMClient();
		vendingMachine.setTitle("SmartCals Vending Machine");		
		vendingMachine.setExtendedState(JFrame.MAXIMIZED_BOTH);
		vendingMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		vendingMachine.setContentPane(pnlContainer);		

		pnlContainer.setBackground(Color.CYAN);
		pnlContainer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
				Color.RED, Color.RED));

		//add Product category selection
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.weightx = 0.2;
		gridConstraints.weighty = 1;
		gridConstraints.fill = GridBagConstraints.BOTH;
		sectionProdCatgeory.setBackground(Color.YELLOW);
		pnlContainer.add(sectionProdCatgeory, gridConstraints); 

		//add Product selection
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		gridConstraints.weightx = 0.2;
		gridConstraints.weighty = 1;
		gridConstraints.fill = GridBagConstraints.BOTH;
		sectionProdSelect.setBackground(Color.PINK);
		pnlContainer.add(sectionProdSelect, gridConstraints);  //** placeholder code

		//add display panel in bottom
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 2;	
		gridConstraints.weightx = 0.2;
		gridConstraints.weighty = 1;
		gridConstraints.fill = GridBagConstraints.BOTH;
		pnlContainer.add(sectionDetails, gridConstraints);

		vendingMachine.pack();
		vendingMachine.setVisible(true);		
	}


	public static void main(String[] args) {	
		createAndShowGUI();
		//code change in progress-Aparna
		/*JPanel panel = new VMSelectionView();
		VMClient vendingMachine = new VMClient();
		vendingMachine.setContentPane(panel);
		vendingMachine.pack();
		vendingMachine.setVisible(true);*/	
	}	


}
