/*
 * RenewalPane.java
 */

package library.gui;
import library.controller.RenewalUseCase;
import library.model.Copy;
import library.model.LibraryDatabase;
import library.model.SimpleDate;

/** The pane associated with the "Renewal" tab on the main card of the GUI
 *
 * @author Russell C. Bjork
 *
 * MODIFIED BY:
 */
public class RenewalPane extends javax.swing.JPanel {

  /**
   * Creates new form RenewalPane
   */
  public RenewalPane() {
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

    jLabel1 = new javax.swing.JLabel();
    copyNumberField = new javax.swing.JTextField();
    renewButton = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    callNumberField = new javax.swing.JTextField();

    addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentShown(java.awt.event.ComponentEvent evt) {
          formComponentShown(evt);
        }
      });
    setLayout(new java.awt.GridBagLayout());

    jLabel1.setText("Copy Number");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(jLabel1, gridBagConstraints);

    copyNumberField.setColumns(20);
    copyNumberField.addCaretListener(new javax.swing.event.CaretListener() {
        public void caretUpdate(javax.swing.event.CaretEvent evt) {
          copyNumberFieldCaretUpdate(evt);
        }
      });
    copyNumberField.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          copyNumberFieldActionPerformed(evt);
        }
      });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(copyNumberField, gridBagConstraints);

    renewButton.setText("Renew");
    renewButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          renewButtonActionPerformed(evt);
        }
      });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(renewButton, gridBagConstraints);

    jLabel2.setText("Call Number");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(jLabel2, gridBagConstraints);

    callNumberField.setColumns(20);
    callNumberField.addCaretListener(new javax.swing.event.CaretListener() {
        public void caretUpdate(javax.swing.event.CaretEvent evt) {
          callNumberFieldCaretUpdate(evt);
        }
      });
    callNumberField.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          callNumberFieldActionPerformed(evt);
        }
      });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(callNumberField, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    callNumberField.setText("");
    callNumberField.setEnabled(true);
    callNumberField.requestFocus();
    copyNumberField.setText("");
    copyNumberField.setEnabled(true);
    renewButton.setEnabled(false);
  }//GEN-LAST:event_formComponentShown

  private void copyNumberFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_copyNumberFieldCaretUpdate
    renewButton.setEnabled(callNumberField.getText().length() != 0);
  }//GEN-LAST:event_copyNumberFieldCaretUpdate

  private void renewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renewButtonActionPerformed
    String callNumber = callNumberField.getText();
    int copyNumber = Integer.parseInt(copyNumberField.getText());
    try
    {
      Copy copy = LibraryDatabase.getInstance().getCopy(callNumber, copyNumber);
      RenewalUseCase.getInstance().perform(copy);
    }
    catch(NumberFormatException e) {
      GUI.getInstance().showMessage("Copy number must be an integer");
    }
    catch(IllegalArgumentException e) {
      GUI.getInstance().showMessage(e.getMessage());
    }
    callNumberField.setText("");
    copyNumberField.setText("");
    callNumberField.requestFocus();
    renewButton.setEnabled(false);

  }//GEN-LAST:event_renewButtonActionPerformed

  private void callNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callNumberFieldActionPerformed
    if (renewButton.isEnabled())
      renewButtonActionPerformed(evt);
  }//GEN-LAST:event_callNumberFieldActionPerformed

  private void callNumberFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_callNumberFieldCaretUpdate
    renewButton.setEnabled(callNumberField.getText().length() != 0);
  }//GEN-LAST:event_callNumberFieldCaretUpdate

  private void copyNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyNumberFieldActionPerformed
    if (renewButton.isEnabled())
      renewButtonActionPerformed(evt);
  }//GEN-LAST:event_copyNumberFieldActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField callNumberField;
  private javax.swing.JTextField copyNumberField;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JButton renewButton;
  // End of variables declaration//GEN-END:variables
}
