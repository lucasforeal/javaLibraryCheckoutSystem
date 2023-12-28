/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library.gui;

import library.controller.LoginOut;

/**
 *
 * @author bjork
 */
public class PasswordDialog extends javax.swing.JDialog {

  /**
   * Creates new form PasswordDialog
   */
  public PasswordDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    setLocationRelativeTo(parent);
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

    jLabel1 = new javax.swing.JLabel();
    passwordField = new javax.swing.JPasswordField();
    loginButton = new javax.swing.JButton();
    cancelButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Enter Password");
    addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentShown(java.awt.event.ComponentEvent evt) {
          formComponentShown(evt);
        }
      });
    getContentPane().setLayout(new java.awt.GridBagLayout());

    jLabel1.setText("Password:");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    getContentPane().add(jLabel1, gridBagConstraints);

    passwordField.setText("jPasswordField1");
    passwordField.addCaretListener(new javax.swing.event.CaretListener() {
        public void caretUpdate(javax.swing.event.CaretEvent evt) {
          passwordFieldCaretUpdate(evt);
        }
      });
    passwordField.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          passwordFieldActionPerformed(evt);
        }
      });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    getContentPane().add(passwordField, gridBagConstraints);

    loginButton.setText("Login");
    loginButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          loginButtonActionPerformed(evt);
        }
      });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
    gridBagConstraints.insets = new java.awt.Insets(9, 9, 9, 9);
    getContentPane().add(loginButton, gridBagConstraints);

    cancelButton.setText("Cancel");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          cancelButtonActionPerformed(evt);
        }
      });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
    getContentPane().add(cancelButton, gridBagConstraints);

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void passwordFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_passwordFieldCaretUpdate
    loginButton.setEnabled(passwordField.getPassword().length > 0);
  }//GEN-LAST:event_passwordFieldCaretUpdate

  private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    passwordField.setText("");
    passwordField.requestFocus();
    loginButton.setEnabled(false);
    result = "";
  }//GEN-LAST:event_formComponentShown

  private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
    result = new String(passwordField.getPassword());
    setVisible(false);
  }//GEN-LAST:event_loginButtonActionPerformed

  private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
    if (loginButton.isEnabled())
      loginButtonActionPerformed(evt);
  }//GEN-LAST:event_passwordFieldActionPerformed

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    result = "";
    setVisible(false);
  }//GEN-LAST:event_cancelButtonActionPerformed

  /** Get the password entered in this dialog once it is popped down
   *
   *  @return the password entered - null if the user canceled
   */
  public String getPassword()
    {
      if (result.length() == 0)
        return null;
      else
        return result;
    }

  private String result;

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton cancelButton;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JButton loginButton;
  private javax.swing.JPasswordField passwordField;
  // End of variables declaration//GEN-END:variables
}
