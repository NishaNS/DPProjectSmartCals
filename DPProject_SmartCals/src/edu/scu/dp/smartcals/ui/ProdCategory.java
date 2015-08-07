import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Thenu
 */
public class ProdCategory extends javax.swing.JPanel {

    /**
     * Creates new form ProdCategory
     */
    public ProdCategory() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
        java.awt.GridBagConstraints gridBagConstraints;
        pnlProdCategory = new javax.swing.JPanel();
        btnBeverage = new javax.swing.JButton();
        btnSnack = new javax.swing.JButton();
        btnCandy = new javax.swing.JButton();
    	Image bevImg = null;
    	Image snackImg = null;
     

        pnlProdCategory.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ProductCategory", 0, 0, new java.awt.Font("Trebuchet MS", 1, 14), java.awt.Color.black)); // NOI18N

        btnBeverage.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
       
	
		try {
			bevImg = ImageIO.read(new File("images\\bev.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Image bevNewImg = bevImg.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
	   
        btnBeverage.setIcon(new javax.swing.ImageIcon(bevNewImg)); // NOI18N
        btnBeverage.setText("Beverage");
        btnBeverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSnack.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        
		
		try {
			snackImg = ImageIO.read(new File("DPProjectSmartCals\DPProject_SmartCals\images\Snacks.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Image snackNewImg = snackImg.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH ) ;  
	   
        btnSnack.setIcon(snackNewImg); // NOI18N
        btnSnack.setText("Snacks");
        btnSnack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnCandy.setFont(new java.awt.Font("Tahoma", 1, 27)); // NOI18N
        btnCandy.setIcon(new javax.swing.ImageIcon("C:\\Users\\Thenu\\Documents\\NetBeansProjects\\Samples\\bev.png")); // NOI18N
        btnCandy.setText("Candy");
        btnCandy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProdCategoryLayout = new javax.swing.GroupLayout(pnlProdCategory);
        pnlProdCategory.setLayout(pnlProdCategoryLayout);
        pnlProdCategoryLayout.setHorizontalGroup(
        		pnlProdCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProdCategoryLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btnBeverage, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnSnack, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(btnCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );

        pnlProdCategoryLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBeverage, btnSnack, btnCandy});

        pnlProdCategoryLayout.setVerticalGroup(
        		   pnlProdCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProdCategoryLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(pnlProdCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnBeverage, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSnack, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCandy, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pnlProdCategoryLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBeverage, btnSnack, btnCandy});

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    
                    .addComponent(pnlProdCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(pnlProdCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                )
        );
        
 
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.out.println("Beverage");
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.out.println("Snack");
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      System.out.println("Candy");
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBeverage;
    private javax.swing.JButton btnSnack;
    private javax.swing.JButton btnCandy;
    private javax.swing.JPanel pnlProdCategory;

    // End of variables declaration                   
}

