package edu.scu.dp.smartcals.ui;

import java.util.List;

import javax.swing.JButton;

import edu.scu.dp.smartcals.vm.VMController;
import edu.scu.dp.smartcals.vm.VendingMachine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *@author Aparna Ganesh
 * @author Nisha
 */
public class VMSelectionView extends javax.swing.JPanel {

	//code change in progress -Aparna
	VMController controller;

	/**
	 * Creates new form SelectVM
	 */
	public VMSelectionView() {
		//code change done in progress-Aparna
		controller = new VMController();
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	
	/**
	 * Code change in progress -Aparna
	 */
	/*public void displayAllVendingMachines() {

		List<VendingMachine> vendingMachines = controller
				.getAllVendingMachines();

		for (VendingMachine vm : vendingMachines) {
			JButton button = new JButton(vm.getLocationType() + "@"
					+ vm.getLocation());
		}
	}*/

	private void initComponents() {
		setLayout(new java.awt.GridBagLayout());
		java.awt.GridBagConstraints gridBagConstraints;
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.weightx = 0.3;
		gridBagConstraints.weighty = 0.3;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 60, 80);
		
		/**
		 * Code change in progress -Aparna
		 */	
		List<VendingMachine> vendingMachines = controller
				.getAllVendingMachines();

		for (VendingMachine vm : vendingMachines) {
			JButton button = new JButton(vm.getLocationType() + "@"	+ vm.getLocation());
			add(button, gridBagConstraints);
		}
		

		

	}// </editor-fold>

	
}
