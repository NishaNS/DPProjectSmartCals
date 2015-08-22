package edu.scu.dp.smartcals.test;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.handler.MessageContext.Scope;

public class TestTable extends JPanel {
	
	private JTable tblRevenue;
	private JScrollPane scrollPane;
	
	public TestTable() {
		
		
		String columnNames[] = { "VMID", "DailySalesAmt", "TotalSales"};
		// Create some data
		String dataValues[][] =
		{
			{ "12", "234", "67" },
			{ "123", "43", "853" },
			{ "93", "89.2", "109" },
			{ "279", "9033", "3092" }
		};
				
		//create data model
		DefaultTableModel tblModel = new DefaultTableModel(dataValues, columnNames);
		
		//create table and add model to table
		tblRevenue = new JTable(tblModel);
		
		//create scrollpane and add table to it
		scrollPane = new JScrollPane(tblRevenue);
		
		//add scrollpane(with table) to this panel
		this.add(scrollPane);
		
		this.setBackground(Color.PINK);
		
		
	}

	public static void main(String[] args){
		JFrame window = new JFrame("Test JTable");
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = window.getContentPane();
		
		TestTable testTable = new TestTable();
		c.add(testTable);
		window.setVisible(true);
	}
}


