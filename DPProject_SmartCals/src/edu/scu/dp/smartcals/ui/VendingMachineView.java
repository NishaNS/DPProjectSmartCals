package edu.scu.dp.smartcals.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.scu.dp.smartcals.vm.VMController;

/**
 * @author Nisha Narayanaswamy 
 * 
 * VendingMachineView class collates the views for ProdCategory, ProdListing and DetailsView classes
 */
public class VendingMachineView extends JPanel {
	
	private VMController vmController;
	private VMProdCategory vmProdCategory;
	private VMDetails_View vmDetailsView;
	private GridBagLayout gridLayout;
	private GridBagConstraints gridConstraints;
	
	
	public VendingMachineView(VMController vmController){
		this.vmController = vmController;
		gridLayout = new GridBagLayout();
		gridConstraints = new GridBagConstraints();
		vmProdCategory = new VMProdCategory();		
		addVMSubPanels();		
	}

	/**
	 * add all 3 inner panels ProdCategory, ProdListing and DetailsView  
	 */
	public void addVMSubPanels() {	
	
		this.setLayout(gridLayout);		
		
		//add Product category selection
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.weightx = 0.2;
		gridConstraints.fill = GridBagConstraints.BOTH;
		this.add(vmProdCategory, gridConstraints);
		

		/*//add Product selection
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
		pnlContainer.add(sectionDetails, gridConstraints);*/
		
	}

}
