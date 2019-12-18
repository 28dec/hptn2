/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.Controller;
import Models.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author longnh
 */
public class SelectReservationFrm extends javax.swing.JFrame {
    private Controller controller;
    private List<Reservation> reservations;
    /**
     * Creates new form SelectReservation
     */
    public SelectReservationFrm(Controller ctrl) {
        initComponents();
        this.controller = ctrl;
        load_reservations();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reservations_cbb = new javax.swing.JComboBox<>();
        make_payment_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        reservations_cbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        make_payment_btn.setText("Thanh toán");
        make_payment_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                make_payment_btnActionPerformed(evt);
            }
        });

        jLabel1.setText("Chọn bàn:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(reservations_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(make_payment_btn)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reservations_cbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(make_payment_btn))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void make_payment_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_make_payment_btnActionPerformed
        System.out.println(evt.getActionCommand());
        if(this.reservations_cbb.getSelectedItem().toString().equals("...")){
            JOptionPane.showMessageDialog(null, "Chưa chọn bàn!", "Thông báo", JOptionPane.PLAIN_MESSAGE);
        } else {
            this.controller.set_reservation_by_id(reservations, Integer.parseInt(this.reservations_cbb.getSelectedItem().toString().split("-")[0]));
            JFrame make_payment_frm = new MakePaymentFrm(this.controller);
            make_payment_frm.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_make_payment_btnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton make_payment_btn;
    private javax.swing.JComboBox<String> reservations_cbb;
    // End of variables declaration//GEN-END:variables

    private void load_reservations(){
        System.out.println(this.getClass() + " load_reservations() performed!");
        reservations = this.controller.get_all_reservations();
        this.reservations_cbb.removeAllItems();
        this.reservations_cbb.addItem("...");
        for(Reservation r: reservations){
            this.reservations_cbb.addItem(r.to_combobox_string());
        }
    }
    
}
