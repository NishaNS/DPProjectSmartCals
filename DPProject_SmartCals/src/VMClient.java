import java.awt.BorderLayout;
import java.awt.Color;
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
	private static GridLayout gridLayout;
	
	
	public VMClient(){
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		pnlContainer = new JPanel();
		gridLayout = new GridLayout(3,1, 2, 2);
	}
	
	private static void createAndShowGUI() {
		VMClient vendingMachine = new VMClient();
		vendingMachine.setTitle("SmartCals Vending Machine");
		
		vendingMachine.setExtendedState(JFrame.MAXIMIZED_BOTH);
		vendingMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		vendingMachine.setContentPane(pnlContainer);
		
		pnlContainer.setBackground(Color.LIGHT_GRAY);
		pnlContainer.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
		        Color.RED, Color.RED));
		
		pnlContainer.setLayout(gridLayout);
		
		vendingMachine.pack();
		vendingMachine.setVisible(true);		
	}


	public static void main(String[] args) {	
		createAndShowGUI();	

	}	
}
