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
	private static GridLayout gridLayout;
	private static GridBagConstraints gridConstraints;
	
	
	public VMClient(){
		
		pnlContainer = new JPanel();
		gridLayout = new GridLayout(2, 1, 2, 2);
		gridConstraints = new GridBagConstraints();
		
		sectionDetails = new VMDetails_View();
		
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
		
		
		/*gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.fill = GridBagConstraints.BOTH;
		gridConstraints.anchor = GridBagConstraints.LAST_LINE_START;		
		gridConstraints.weightx = 0.5;
		gridConstraints.weighty = 0.5;		*/
		
		//add display panel in bottom
		pnlContainer.add(sectionDetails);
		
		vendingMachine.pack();
		vendingMachine.setVisible(true);		
	}


	public static void main(String[] args) {	
		createAndShowGUI();	

	}	
	
	private static VMDetails_View sectionDetails;
}
