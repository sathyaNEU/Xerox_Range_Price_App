/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Main.WorkSpaceProfiles.OrderManagement;

import UserInterface.ProductManagement.*;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.OrderManagement.MasterOrderList;
import TheBusiness.OrderManagement.Order;
import TheBusiness.OrderManagement.OrderItem;
import TheBusiness.ProductManagement.Product;
import TheBusiness.ProductManagement.ProductCatalog;
import TheBusiness.ProductManagement.ProductSummary;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.Supplier.Supplier;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kal bugrara
 */
public class ProcessOrder extends javax.swing.JPanel {

    /**
     * Creates new form ManageSuppliersJPanel
     */
    //JPanel CardSequencePanel;
    JPanel userProcessContainer;
    Business business;
    Supplier selectedsupplier;
    Product selectedproduct;
    Order currentOrder;
    CustomerProfile customer;
    SalesPersonProfile salesperson;
    MasterOrderList mol;

    public ProcessOrder(Business bz, SalesPersonProfile spp, JPanel userProcessContainer,CustomerProfile cp) {

        this.userProcessContainer = userProcessContainer;
        this.business = bz;
        initComponents();
       
        customer = cp;
        salesperson = spp;
        salesPersonTextField.setText(salesperson.getPerson().toString());
        salesPersonTextField.setEditable(false);
        customerTextField.setText(customer.getCustomerId());
        customerTextField.setEditable(false);
        mol = business.getMasterOrderList();
        currentOrder =  mol.newOrder(customer, salesperson); //no order was made yet
        initializeTable();

    }

    private void initializeTable() {

//clear supplier table
        cleanUpCombobox();
        cleanUpTable();

//load suppliers to the combobox
        ArrayList<Supplier> supplierlist = business.getSupplierDirectory().getSuplierList();

        if (supplierlist.isEmpty()) {
            return;
        }

        for (Supplier s : supplierlist) {
            
            SuppliersComboBox.addItem(s.toString());
            SuppliersComboBox.setSelectedIndex(0);
            String suppliername = (String) SuppliersComboBox.getSelectedItem();
            selectedsupplier = business.getSupplierDirectory().findSupplier(suppliername);
            ProductCatalog pc = selectedsupplier.getProductCatalog();
            for (Product pt : pc.getProductList()) {

                Object[] row = new Object[5];
                row[0] = pt;
                row[1] = pt.getFloorPrice();
                row[2] = pt.getCeilingPrice();
                row[3] = pt.getTargetPrice();

                ((DefaultTableModel) tblProduct.getModel()).addRow(row);
            }

        }
    }

    public void cleanUpCombobox() {
        //Clean the combobox for supplier choices

        SuppliersComboBox.removeAllItems();

    }

    public void cleanUpTable() {

        //Clean the product catalog table
        int rc = tblProduct.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) tblProduct.getModel()).removeRow(i);
        }
    }
    public void cleanUpItemsTable() {

        //Clean the product catalog table
        int rc = OrderItemsTable.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) OrderItemsTable.getModel()).removeRow(i);
        }
    }

    public void refreshSupplierProductCatalogTable() {

//clear supplier table
        int rc = tblProduct.getRowCount();
        int i;
        for (i = rc - 1; i >= 0; i--) {
            ((DefaultTableModel) tblProduct.getModel()).removeRow(i);
        }

        String suppliername = (String) SuppliersComboBox.getSelectedItem();

        selectedsupplier = business.getSupplierDirectory().findSupplier(suppliername);
        if (selectedsupplier == null) {
            return;
        }
        ProductCatalog pc = selectedsupplier.getProductCatalog();

        for (Product pt : pc.getProductList()) {

            Object[] row = new Object[5];
            row[0] = pt;
            row[1] = pt.getFloorPrice();
            row[2] = pt.getCeilingPrice();
            row[3] = pt.getTargetPrice();
//                row[1] = pt.getPerformanceMeasure();
//               row[2] = la.getName();
            ((DefaultTableModel) tblProduct.getModel()).addRow(row);
        }

    }
     private void populateProductItemTable() {
        DefaultTableModel model = (DefaultTableModel) OrderItemsTable.getModel();
        model.setRowCount(0);

        for (OrderItem oi : currentOrder.getOrderitems()) {
            Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getActualPrice();
            row[2] = oi.getQuantity();
            row[3] = oi.getQuantity() * oi.getActualPrice();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        Next = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        SuppliersComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        customerTextField = new javax.swing.JTextField();
        salesPersonTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        productFrequencyBelowTargetTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        productFrequencyAboveTargetTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        productPricePerformanceTextField = new javax.swing.JTextField();
        productRevenueTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        productNameTextField = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblSalesPrice = new javax.swing.JLabel();
        txtSalesPrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        spnQuantity = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        OrderItemsTable = new javax.swing.JTable();
        btnRemoveOrderItem = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Back.setText("X Cancel");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 80, -1));

        Next.setText("Order Item");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });
        add(Next, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 110, -1));

        jLabel1.setText("Suppliers");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 60, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Prepare Order");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 550, -1));

        jLabel8.setText("Product");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jLabel9.setText("Order Items");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 20));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductItemActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 90, 30));

        SuppliersComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuppliersComboBoxActionPerformed(evt);
            }
        });
        add(SuppliersComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        jLabel10.setText("Customer");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 150, -1));

        customerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerTextFieldActionPerformed(evt);
            }
        });
        add(customerTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 160, -1));
        add(salesPersonTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 160, -1));

        jLabel11.setText("Sales person");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 150, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Business-wide Product Intelligence", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Frequency Below Target");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 150, -1));
        jPanel1.add(productFrequencyBelowTargetTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 150, -1));

        jLabel4.setText("Frequency Above Target");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 150, -1));
        jPanel1.add(productFrequencyAboveTargetTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 150, -1));

        jLabel7.setText("Marign around target");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 150, -1));

        productPricePerformanceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productPricePerformanceTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(productPricePerformanceTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 150, -1));

        productRevenueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productRevenueTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(productRevenueTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 150, -1));

        jLabel5.setText("Sales Revenues");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, -1));

        jLabel3.setText("Product name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 110, -1));

        productNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productNameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(productNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 600, 170));
        jPanel1.getAccessibleContext().setAccessibleName("Business -wide Product Intelligence");

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, -1));

        lblSalesPrice.setText("Sales Price:");
        add(lblSalesPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, 20));

        txtSalesPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalesPriceActionPerformed(evt);
            }
        });
        add(txtSalesPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 70, -1));

        lblQuantity.setText("Quantity:");
        add(lblQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, -1, -1));

        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        add(spnQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        tblProduct.setFont(new java.awt.Font("Lucida Grande", 0, 13)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Floor", "Ceiling", "Target"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 570, 110));

        OrderItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Actual price", "Quanity", "Item total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        OrderItemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OrderItemsTableMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OrderItemsTableMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(OrderItemsTable);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 588, 110));

        btnRemoveOrderItem.setText("Remove Item");
        btnRemoveOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveOrderItemActionPerformed(evt);
            }
        });
        add(btnRemoveOrderItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
//        currentOrder.CancelOrder();
//        CardSequencePanel.remove(this);
//        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);

    }//GEN-LAST:event_BackActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
        
        mol.AddNewOrder(currentOrder);
        JOptionPane.showMessageDialog(this, "Order placed successfully");

        cleanUpItemsTable();
        txtSalesPrice.setText("");
        spnQuantity.setValue(0);
        
        
//        currentOrder.Submit();
//        CardSequencePanel.remove(this);
//        ((java.awt.CardLayout) CardSequencePanel.getLayout()).next(CardSequencePanel);
        

    }//GEN-LAST:event_NextActionPerformed

    private void productNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productNameTextFieldActionPerformed

    private void productRevenueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productRevenueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productRevenueTextFieldActionPerformed

    private void productPricePerformanceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productPricePerformanceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productPricePerformanceTextFieldActionPerformed

    private void OrderItemsTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderItemsTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderItemsTableMouseEntered

    private void OrderItemsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderItemsTableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderItemsTableMousePressed

    private void AddProductItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductItemActionPerformed
        // TODO add your handling code here:

        int suppliertablesize = tblProduct.getRowCount();
        int selectedrow = tblProduct.getSelectionModel().getLeadSelectionIndex();

        if (selectedrow < 0 || selectedrow > suppliertablesize - 1) {
         JOptionPane.showMessageDialog(this, "Please select the product first.");
         return;
        }
        selectedproduct = (Product) tblProduct.getValueAt(selectedrow, 0);
        int salesPrice = 0;
        int quant = 0;
        try {
            salesPrice = Integer.parseInt(txtSalesPrice.getText());
            quant = (Integer) spnQuantity.getValue();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, "Please check the price and quantity fields.");
            return;
        }
                
        if (salesPrice < selectedproduct.getFloorPrice() || salesPrice > selectedproduct.getCeilingPrice() || quant == 0) {
            JOptionPane.showMessageDialog(this, "Price should be more than floor price and less the ceiling price and Quantity should not be zero");
            return;
        }
        
        else{
        
        OrderItem item = currentOrder.newOrderItem(selectedproduct, salesPrice, quant);
        selectedproduct.addOrderItem(item);
            Object[] row = new Object[4];

            row[0] = item;
            row[1] = String.valueOf(item.getActualPrice());
            row[2] = String.valueOf(item.getQuantity());
            row[3] = String.valueOf(item.getOrderItemTotal());

            ((DefaultTableModel) OrderItemsTable.getModel()).addRow(row);
        }
           
 txtSalesPrice.setText("");
        spnQuantity.setValue(0);

    }//GEN-LAST:event_AddProductItemActionPerformed

    private void SuppliersComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuppliersComboBoxActionPerformed
        // TODO add your handling code here:
     refreshSupplierProductCatalogTable();
    }//GEN-LAST:event_SuppliersComboBoxActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        ((CardLayout) userProcessContainer.getLayout()).previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void customerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerTextFieldActionPerformed

    private void txtSalesPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalesPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalesPriceActionPerformed

    private void btnRemoveOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveOrderItemActionPerformed
        int selectedRowIndex = OrderItemsTable.getSelectedRow();
        if (selectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select the order item first");
        }
        else
        {
            
        OrderItem item = (OrderItem) OrderItemsTable.getValueAt(selectedRowIndex, 0);
        Product selectedProduct = item.getSelectedProduct();
        selectedProduct.removeOrderItem(item);
        currentOrder.deleteItem(item);
         JOptionPane.showMessageDialog(this, "Selected product deleted successfully");
         populateProductItemTable();
        }

        
    }//GEN-LAST:event_btnRemoveOrderItemActionPerformed

    private void tblProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMousePressed
        // TODO add your handling code here:
         int suppliertablesize = tblProduct.getRowCount();
        int selectedrow = tblProduct.getSelectionModel().getLeadSelectionIndex();

        if (selectedrow < 0 || selectedrow > suppliertablesize - 1) {
            return;
        }
        selectedproduct = (Product) tblProduct.getValueAt(selectedrow, 0);
        if (selectedproduct == null) {
            return;
        }

        ProductSummary productsummary = new ProductSummary(selectedproduct);

        productNameTextField.setText(selectedproduct.toString());
        String revenues = String.valueOf(productsummary.getSalesRevenues());
        productRevenueTextField.setText(revenues);
        productFrequencyAboveTargetTextField.setText(String.valueOf(productsummary.getNumberAboveTarget()));
        productFrequencyBelowTargetTextField.setText(String.valueOf(productsummary.getNumberBelowTarget()));
        productPricePerformanceTextField.setText(String.valueOf(productsummary.getProductPricePerformance()));

    }//GEN-LAST:event_tblProductMousePressed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Next;
    private javax.swing.JTable OrderItemsTable;
    private javax.swing.JComboBox<String> SuppliersComboBox;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemoveOrderItem;
    private javax.swing.JTextField customerTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblSalesPrice;
    private javax.swing.JTextField productFrequencyAboveTargetTextField;
    private javax.swing.JTextField productFrequencyBelowTargetTextField;
    private javax.swing.JTextField productNameTextField;
    private javax.swing.JTextField productPricePerformanceTextField;
    private javax.swing.JTextField productRevenueTextField;
    private javax.swing.JTextField salesPersonTextField;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtSalesPrice;
    // End of variables declaration//GEN-END:variables

}
