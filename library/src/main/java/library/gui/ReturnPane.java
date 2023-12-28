/*
 * ReturnPane.java
 */

package library.gui;

import library.controller.ReturnUseCase;
import library.model.Copy;
import library.model.LibraryDatabase;

/** The pane associated with the "Return" tab on the main card of the GUI
 *
 * @author Russell C. Bjork
 *
 * MODIFIED BY:
 */
public class ReturnPane extends javax.swing.JPanel {
  /** Creates new form ReturnPane
   */
  public ReturnPane() {
    initComponents();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    copyNumberField = new javax.swing.JTextField();
    returnCopyButton = new javax.swing.JButton();
    copyLabel = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    callNumberField = new javax.swing.JTextField();

    addComponentListener(new java.awt.event.ComponentAdapter() {
        public void componentShown(java.awt.event.ComponentEvent evt) {
          formComponentShown(evt);
        }
      });
    setLayout(new java.awt.GridBagLayout());

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
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(copyNumberField, gridBagConstraints);

    returnCopyButton.setText("Return Copy");
    returnCopyButton.setEnabled(false);
    returnCopyButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          returnCopyButtonActionPerformed(evt);
        }
      });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(returnCopyButton, gridBagConstraints);

    copyLabel.setLabelFor(copyNumberField);
    copyLabel.setText("Copy Number");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(copyLabel, gridBagConstraints);

    jLabel1.setText("Call Number");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
    add(jLabel1, gridBagConstraints);

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

  /** The following code is executed each time the pane is shown
      It resets the item field to blank and requests focus for it */
  private void formComponentShown(java.awt.event.ComponentEvent evt)//GEN-FIRST:event_formComponentShown
    {//GEN-HEADEREND:event_formComponentShown
      callNumberField.setText("");
      copyNumberField.setText("");
      callNumberField.requestFocus();
      returnCopyButton.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

  /** Enable the return item button just when the return item field is non-empty */
  private void copyNumberFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_copyNumberFieldCaretUpdate
    returnCopyButton.setEnabled(callNumberField.getText().length() != 0);
  }//GEN-LAST:event_copyNumberFieldCaretUpdate

  /** Make pressing return in the item field equivalent to clicking the return item button */
  private void copyNumberFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_copyNumberFieldActionPerformed
    {//GEN-HEADEREND:event_copyNumberFieldActionPerformed
      if (returnCopyButton.isEnabled())
        returnCopyButtonActionPerformed(evt);
    }//GEN-LAST:event_copyNumberFieldActionPerformed

  /** Return an item */
  private void returnCopyButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_returnCopyButtonActionPerformed
    {//GEN-HEADEREND:event_returnCopyButtonActionPerformed
      String callNumber = callNumberField.getText();
      int copyNumber = Integer.parseInt(copyNumberField.getText());
      try
      {
        Copy copy = LibraryDatabase.getInstance()
                .getCopy(callNumber, copyNumber);
        ReturnUseCase.getInstance().perform(copy);
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
      returnCopyButton.setEnabled(false);
    }//GEN-LAST:event_returnCopyButtonActionPerformed

  private void callNumberFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_callNumberFieldCaretUpdate
    returnCopyButton.setEnabled(callNumberField.getText().length() != 0);
  }//GEN-LAST:event_callNumberFieldCaretUpdate

  private void callNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callNumberFieldActionPerformed
    if (returnCopyButton.isEnabled())
      returnCopyButtonActionPerformed(evt);
  }//GEN-LAST:event_callNumberFieldActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField callNumberField;
  private javax.swing.JLabel copyLabel;
  private javax.swing.JTextField copyNumberField;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JButton returnCopyButton;
  // End of variables declaration//GEN-END:variables
}
