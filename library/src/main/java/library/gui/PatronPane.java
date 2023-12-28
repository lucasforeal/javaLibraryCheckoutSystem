/*
 * PatronPane.java
 */

package library.gui;

/** The pane associated with the "Patron" tab on the main card of the GUI
 *
 * @author Russell C. Bjork
 *
 * MODIFIED BY:
 */
public class PatronPane extends javax.swing.JPanel {

  /** Creates new form PatronPane
   */
  PatronPane() {
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

    addPatronButton = new javax.swing.JButton();

    setLayout(new java.awt.GridBagLayout());

    addPatronButton.setText("Add Patron");
    addPatronButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addPatronButtonActionPerformed(evt);
      }
    });
    addPatronButton.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        addPatronButtonKeyPressed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(134, 157, 142, 171);
    add(addPatronButton, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void addPatronButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatronButtonActionPerformed
    GUI.getInstance().gotoCard("patrondetails");  }//GEN-LAST:event_addPatronButtonActionPerformed

  private void addPatronButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addPatronButtonKeyPressed
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
      addPatronButtonActionPerformed(null);
    }
  }//GEN-LAST:event_addPatronButtonKeyPressed
  

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addPatronButton;
  // End of variables declaration//GEN-END:variables

}
