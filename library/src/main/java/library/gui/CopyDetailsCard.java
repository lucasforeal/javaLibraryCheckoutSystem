/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.gui;

import java.util.Iterator;
import library.controller.ItemUseCases;
import library.model.Item;
import library.model.LibraryDatabase;

/** Card for adding details of new copy
 *
 * @author Ben Rogers and Lucas DeAssis
 */
public class CopyDetailsCard extends javax.swing.JPanel {

  /**
   * Creates new form CopyDetailsCard
   */
  public CopyDetailsCard() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    buttonGroup = new javax.swing.ButtonGroup();
    listContainer = new javax.swing.JScrollPane();
    itemList = new javax.swing.JList<>();
    callNumberButton = new javax.swing.JRadioButton();
    itemListButton = new javax.swing.JRadioButton();
    callNumberField = new javax.swing.JTextField();
    cancelButton = new javax.swing.JButton();
    addCopyButton = new javax.swing.JButton();

    setLayout(new java.awt.GridBagLayout());

    itemList.setEnabled(false);
    itemList.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        itemListKeyPressed(evt);
      }
    });
    listContainer.setViewportView(itemList);

    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.gridwidth = 4;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints.ipadx = 225;
    gridBagConstraints.ipady = 101;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.weightx = 1.0;
    gridBagConstraints.weighty = 1.0;
    gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 117);
    add(listContainer, gridBagConstraints);

    buttonGroup.add(callNumberButton);
    callNumberButton.setSelected(true);
    callNumberButton.setText("Call Number");
    callNumberButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        callNumberButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridheight = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(37, 23, 0, 0);
    add(callNumberButton, gridBagConstraints);

    buttonGroup.add(itemListButton);
    itemListButton.setText("List");
    itemListButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        itemListButtonActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 50;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(17, 23, 0, 0);
    add(itemListButton, gridBagConstraints);

    callNumberField.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        callNumberFieldKeyPressed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 35;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(39, 6, 0, 0);
    add(callNumberField, gridBagConstraints);

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
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.ipadx = 13;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(36, 29, 37, 0);
    add(cancelButton, gridBagConstraints);

    addCopyButton.setText("Add Copy");
    addCopyButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        addCopyButtonActionPerformed(evt);
      }
    });
    addCopyButton.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        addCopyButtonKeyPressed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(36, 39, 37, 0);
    add(addCopyButton, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void callNumberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_callNumberButtonActionPerformed
    // Disable and reset item list
    itemList.setEnabled(false);
    itemList.setListData(new String[0]);
    // Enable call number field
    callNumberField.setEnabled(true);
    callNumberField.setText(callNumberFieldString);
  }//GEN-LAST:event_callNumberButtonActionPerformed

  private void itemListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemListButtonActionPerformed
    // Disable and reset call number field
    callNumberField.setEnabled(false);
    callNumberFieldString = callNumberField.getText();
    callNumberField.setText("");
    // Enable item list
    itemList.setEnabled(true);
    String[] items = new String[LibraryDatabase.getInstance()
            .getNumberOfItems()];
    Iterator<Item> itemIterator = LibraryDatabase.getInstance()
            .getItemIterator();
    
    for (int i = 0; i < items.length; i++) {
      Item currentItem = itemIterator.next();
      items[i] = currentItem.getDescription();
    }
    itemList.setListData(items);
  }//GEN-LAST:event_itemListButtonActionPerformed

  private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    ItemUseCases.getInstance().cancel();
    callNumberButtonActionPerformed(null);
    buttonGroup.setSelected(callNumberButton.getModel(), true);
    callNumberField.setText("");
    GUI.getInstance().goBack();
  }//GEN-LAST:event_cancelButtonActionPerformed

  private void addCopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCopyButtonActionPerformed
    if (callNumberField.isEnabled()) { // Listen to call number field
      ItemUseCases.getInstance().addCopy(callNumberField.getText());
    }
    else { // Listen to item list
      try {
        String selected = itemList.getSelectedValue();
        Item thisItem = null;
        // Get call number from description. This can be done by
        // searching for the item in the database's collection
        // with a matching description to the selected item in the GUI
        
        Iterator<Item> i = LibraryDatabase.getInstance().getItemIterator();
        boolean done = false; // keeps track of finding item in loop
        while (i.hasNext() && !done) {
          thisItem = i.next();
          if (thisItem.getDescription().equals(selected)) {
            done = true;
          }
        }
        if (!done) { // item not found, pass in empty string for call number
          ItemUseCases.getInstance().addCopy("");
        }
        else {
          ItemUseCases.getInstance().addCopy(thisItem.getCallNumber()); 
        }
      }
      catch (NullPointerException e) { // No item selected
        GUI.getInstance().showMessage("Please select an item");
      }
    }
  }//GEN-LAST:event_addCopyButtonActionPerformed

  private void addCopyButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addCopyButtonKeyPressed
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
      addCopyButtonActionPerformed(null);
    }
  }//GEN-LAST:event_addCopyButtonKeyPressed

  private void cancelButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelButtonKeyPressed
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
      cancelButtonActionPerformed(null);
    }
  }//GEN-LAST:event_cancelButtonKeyPressed

  private void callNumberFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_callNumberFieldKeyPressed
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
      addCopyButtonActionPerformed(null);
    }
  }//GEN-LAST:event_callNumberFieldKeyPressed

  private void itemListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemListKeyPressed
    if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
      addCopyButtonActionPerformed(null);
    }
  }//GEN-LAST:event_itemListKeyPressed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton addCopyButton;
  private javax.swing.ButtonGroup buttonGroup;
  private javax.swing.JRadioButton callNumberButton;
  private javax.swing.JTextField callNumberField;
  private javax.swing.JButton cancelButton;
  private javax.swing.JList<String> itemList;
  private javax.swing.JRadioButton itemListButton;
  private javax.swing.JScrollPane listContainer;
  // End of variables declaration//GEN-END:variables

  // Variable for saving call number field data when disabling
  private String callNumberFieldString;
}