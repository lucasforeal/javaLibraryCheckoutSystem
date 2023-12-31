/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.gui;

import library.controller.ItemUseCases;

/** Card for entering details of new DVD item
 *
 * @author Ben Rogers and Lucas DeAssis
 */
public class DVDDetailsCard extends javax.swing.JPanel {

  /**
   * Creates new form DVDDetailsPane
   */
  public DVDDetailsCard() {
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
    java.awt.GridBagConstraints gridBagConstraints;

    titleLabel = new javax.swing.JLabel();
    leadActorLabel = new javax.swing.JLabel();
    titleField = new javax.swing.JTextField();
    leadActorField = new javax.swing.JTextField();
    cancelButton = new javax.swing.JButton();
    addDVDButton = new javax.swing.JButton();
    callNumberLabel = new javax.swing.JLabel();
    callNumberField = new javax.swing.JTextField();
    ratingLabel = new javax.swing.JLabel();
    ratingField = new javax.swing.JTextField();

    setLayout(new java.awt.GridBagLayout());

    titleLabel.setText("Title:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(22, 24, 0, 0);
    add(titleLabel, gridBagConstraints);

    leadActorLabel.setText("Lead Actor:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(24, 24, 0, 0);
    add(leadActorLabel, gridBagConstraints);

    titleField.addCaretListener(new javax.swing.event.CaretListener() {
      public void caretUpdate(javax.swing.event.CaretEvent evt) {
        titleFieldCaretUpdate(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.ipadx = 160;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(22, 104, 0, 24);
    add(titleField, gridBagConstraints);

    leadActorField.addCaretListener(new javax.swing.event.CaretListener() {
      public void caretUpdate(javax.swing.event.CaretEvent evt) {
        leadActorFieldCaretUpdate(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.ipadx = 160;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(20, 104, 0, 24);
    add(leadActorField, gridBagConstraints);

    cancelButton.setText("Cancel");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cancelButtonActionPerformed(evt);
      }
    });
    cancelButton.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        cancelButtonKeyPressed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.gridwidth = 3;
    gridBagConstraints.ipadx = 10;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(31, 24, 41, 0);
    add(cancelButton, gridBagConstraints);

    addDVDButton.setText("Add DVD");
    addDVDButton.setEnabled(false);
    addDVDButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addDVDButtonActionPerformed(evt);
      }
    });
    addDVDButton.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        addDVDButtonKeyPressed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 8;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(31, 104, 41, 0);
    add(addDVDButton, gridBagConstraints);

    callNumberLabel.setText("Call Number:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(44, 24, 0, 0);
    add(callNumberLabel, gridBagConstraints);

    callNumberField.addCaretListener(new javax.swing.event.CaretListener() {
      public void caretUpdate(javax.swing.event.CaretEvent evt) {
        callNumberFieldCaretUpdate(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.ipadx = 160;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(40, 104, 0, 24);
    add(callNumberField, gridBagConstraints);

    ratingLabel.setText("Rating:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(26, 24, 0, 0);
    add(ratingLabel, gridBagConstraints);

    ratingField.addCaretListener(new javax.swing.event.CaretListener() {
      public void caretUpdate(javax.swing.event.CaretEvent evt) {
        ratingFieldCaretUpdate(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 4;
    gridBagConstraints.gridy = 6;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.ipadx = 160;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(26, 104, 0, 24);
    add(ratingField, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void titleFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_titleFieldCaretUpdate
    addDVDButton.setEnabled(isAddDVDEnabled());
  }//GEN-LAST:event_titleFieldCaretUpdate

  private void leadActorFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_leadActorFieldCaretUpdate
    addDVDButton.setEnabled(isAddDVDEnabled());
  }//GEN-LAST:event_leadActorFieldCaretUpdate

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    clear();
    ItemUseCases.getInstance().cancel();
    GUI.getInstance().goBack();
  }//GEN-LAST:event_cancelButtonActionPerformed

  private void cancelButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelButtonKeyPressed
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
      cancelButtonActionPerformed(null);
    }
  }//GEN-LAST:event_cancelButtonKeyPressed

  private void addDVDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDVDButtonActionPerformed
    try {
      String callNumber = callNumberField.getText();
      String title = titleField.getText();
      String leadActor = leadActorField.getText();
      String rating = ratingField.getText();
      ItemUseCases.getInstance().addItem(callNumber, title, leadActor, rating);
      GUI.getInstance().showMessage("DVD added successfully!");
    }
    catch (IllegalArgumentException e) {
      GUI.getInstance().showMessage(e.getMessage());
    }
    clear();
  }//GEN-LAST:event_addDVDButtonActionPerformed

  private void addDVDButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addDVDButtonKeyPressed
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
      addDVDButtonActionPerformed(null);
    }
  }//GEN-LAST:event_addDVDButtonKeyPressed

  private void callNumberFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_callNumberFieldCaretUpdate
    addDVDButton.setEnabled(isAddDVDEnabled());
  }//GEN-LAST:event_callNumberFieldCaretUpdate

  private void ratingFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_ratingFieldCaretUpdate
    addDVDButton.setEnabled(isAddDVDEnabled());
  }//GEN-LAST:event_ratingFieldCaretUpdate

  // Helper function to enable addDVDButton
  private boolean isAddDVDEnabled() {
    return callNumberField.getText().length() > 0 &&
           titleField.getText().length() > 0 &&
           leadActorField.getText().length() > 0 &&
           ratingField.getText().length() > 0;
  }
  
  /** Clears all fields in the card
   */
  private void clear() {
    callNumberField.setText("");
    titleField.setText("");
    leadActorField.setText("");
    ratingField.setText("");
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addDVDButton;
  private javax.swing.JTextField callNumberField;
  private javax.swing.JLabel callNumberLabel;
  private javax.swing.JButton cancelButton;
  private javax.swing.JTextField leadActorField;
  private javax.swing.JLabel leadActorLabel;
  private javax.swing.JTextField ratingField;
  private javax.swing.JLabel ratingLabel;
  private javax.swing.JTextField titleField;
  private javax.swing.JLabel titleLabel;
  // End of variables declaration//GEN-END:variables
}
