/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * WorkAreaJPanel.java
 *
 * Created on May 17, 2020, 8:35:29 AM
 */
package UserInterface.Main.WorkSpaceProfiles;

import TheBusiness.Business.Business;
import UserInterface.ManageTheBusiness.ManageChannelMarketJPanel;
import UserInterface.ManageTheBusiness.ManagePriceJPanel;
import UserInterface.ManageTheBusiness.ManageTheBusinessJPanel;
import UserInterface.ManageTheBusiness.PerformanceReportsJPanel;
import UserInterface.ManageTheBusiness.ProductSolutionPanel;
import UserInterface.ProductManagement.ManageSuppliersJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author kal
 */
public class MarketingManagerWorkAreaJPanel1 extends javax.swing.JPanel {

    JPanel CardSequencePanel;
    Business business;

    /**
     * Creates new form UnitRiskWorkArea
     */

    public MarketingManagerWorkAreaJPanel1(Business b, JPanel clp) {

        business = b;
        this.CardSequencePanel = clp;
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        btnManageChannel = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        solutionBundleBtn = new javax.swing.JButton();

        setForeground(new java.awt.Color(51, 51, 51));

        jButton4.setBackground(new java.awt.Color(102, 153, 255));
        jButton4.setFont(getFont());
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Manage Markets");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton4.setMinimumSize(new java.awt.Dimension(20, 23));
        jButton4.setPreferredSize(new java.awt.Dimension(240, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4IdentifyResourceAssetsActionPerformed(evt);
            }
        });

        btnManageChannel.setBackground(new java.awt.Color(102, 153, 255));
        btnManageChannel.setFont(getFont());
        btnManageChannel.setForeground(new java.awt.Color(255, 255, 255));
        btnManageChannel.setText("Manage Channels");
        btnManageChannel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnManageChannel.setMaximumSize(new java.awt.Dimension(200, 40));
        btnManageChannel.setMinimumSize(new java.awt.Dimension(20, 20));
        btnManageChannel.setPreferredSize(new java.awt.Dimension(240, 25));
        btnManageChannel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageChannelActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(102, 153, 255));
        jButton6.setFont(getFont());
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Manage Prices");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setMaximumSize(new java.awt.Dimension(145, 40));
        jButton6.setMinimumSize(new java.awt.Dimension(20, 20));
        jButton6.setPreferredSize(new java.awt.Dimension(240, 25));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6IdentifyEventsActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(102, 153, 255));
        jButton11.setFont(getFont());
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Performance Reports");
        jButton11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.setMaximumSize(new java.awt.Dimension(200, 40));
        jButton11.setMinimumSize(new java.awt.Dimension(20, 20));
        jButton11.setPreferredSize(new java.awt.Dimension(240, 25));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Marketing ");

        solutionBundleBtn.setBackground(new java.awt.Color(102, 153, 255));
        solutionBundleBtn.setForeground(new java.awt.Color(255, 255, 255));
        solutionBundleBtn.setText("Manage Solution Bundle");
        solutionBundleBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        solutionBundleBtn.setMaximumSize(new java.awt.Dimension(145, 40));
        solutionBundleBtn.setMinimumSize(new java.awt.Dimension(20, 20));
        solutionBundleBtn.setPreferredSize(new java.awt.Dimension(240, 25));
        solutionBundleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solutionBundleBtnIdentifyEventsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(solutionBundleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75)
                            .addComponent(btnManageChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(632, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnManageChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(solutionBundleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4IdentifyResourceAssetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4IdentifyResourceAssetsActionPerformed
        // TODO add your handling code here:
        CardSequencePanel.removeAll();

        ManageTheBusinessJPanel aos = new ManageTheBusinessJPanel(business, CardSequencePanel);

        CardSequencePanel.add("ManageVulns", aos);
        ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_jButton4IdentifyResourceAssetsActionPerformed

    private void btnManageChannelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageChannelActionPerformed
        // TODO add your handling code here:

        

        ManageChannelMarketJPanel manageChannelMarketJPanel = new ManageChannelMarketJPanel(business, CardSequencePanel);

        CardSequencePanel.add("ManageChannelMarketJPanel", manageChannelMarketJPanel);
        ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_btnManageChannelActionPerformed

    private void jButton6IdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6IdentifyEventsActionPerformed
         // TODO add your handling code here:
      ManagePriceJPanel mpj = new ManagePriceJPanel(business, CardSequencePanel);
      CardSequencePanel.add("ManagePriceJPanel", mpj);
      ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
}//GEN-LAST:event_jButton6IdentifyEventsActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        PerformanceReportsJPanel prj = new PerformanceReportsJPanel(business, CardSequencePanel);
       CardSequencePanel.add("PerformanceReportsJPanel", prj);
       ((CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

        
}//GEN-LAST:event_jButton11ActionPerformed

    private void solutionBundleBtnIdentifyEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solutionBundleBtnIdentifyEventsActionPerformed
             // TODO add your handling code here:
        ProductSolutionPanel productSolutionBundleJPanel = new ProductSolutionPanel(this.business,this.CardSequencePanel);
        this.CardSequencePanel.add("productSolutionBundleJPanel",productSolutionBundleJPanel);
        ((CardLayout)this.CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_solutionBundleBtnIdentifyEventsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageChannel;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton solutionBundleBtn;
    // End of variables declaration//GEN-END:variables

}
