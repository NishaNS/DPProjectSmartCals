package edu.scu.dp.smartcals.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import edu.scu.dp.smartcals.vm.VMController;

/**
 * @author Nisha Narayanaswamy
 * 
 * Tabbed view for displaying the VendingMachineView and MonitoringStation.
 *
 */
public class TabbedView extends JPanel {
	
	private VMController vmController;
	private JTabbedPane tabPane;
	
	//temp 
	private JPanel ms = new MonitoringStationView();
	private JPanel p2 = new JPanel();
	
	public TabbedView(){
		
		
		tabPane = new JTabbedPane();
		
		//this layout step is important - decide # of rows,cols for span width,height
		this.setLayout(new GridLayout(1,1));
		
		ms.setBackground(Color.PINK);
		p2.setBackground(Color.YELLOW);
		
		tabPane.addTab("panel1", ms);
		tabPane.addTab("panel2", p2);
		
		this.add(tabPane);
	}
	
	public static void main(String[] args){
		JFrame window = new JFrame();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TabbedView t = new TabbedView();
		Container c = window.getContentPane();
		c.add(t);
		window.setVisible(true);
		
	}

}
