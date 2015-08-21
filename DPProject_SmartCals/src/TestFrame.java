import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Aparna Ganesh
 * Sample Test Frame--
 */
public class TestFrame extends JFrame{
	
	public void showUI() {
		JPanel panel = new ProductInfoPanel("label-1", "label-2", "label-3");
		setContentPane(panel);
	}
	
	
	class ProductInfoPanel extends JPanel {
		
		private JLabel productIdLbl;
		private JLabel productNameLbl;
		private JLabel productPriceLbl;
		private JButton button;
		
		public ProductInfoPanel(String id,String name,String price) {
			productIdLbl = new JLabel(id);
			productNameLbl = new JLabel(name);
			productPriceLbl = new JLabel(price);
			button = new JButton("Button");
			add(productIdLbl);
			add(productNameLbl);
			add(productPriceLbl);
			add(button);
		}
		
	}
	
	public static void main(String args[]) {
		TestFrame frame = new TestFrame();
		frame.showUI();
		frame.pack();
		frame.setVisible(true);
	}

}
