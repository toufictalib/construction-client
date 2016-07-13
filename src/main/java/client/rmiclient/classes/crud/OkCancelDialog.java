/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rmiclient.classes.crud;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 *
 * @author User
 */
public class OkCancelDialog extends javax.swing.JDialog {

    private JComponent original;
    private JComponent component;
    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    
    
    private String okLabel = "OK";
    
    private Window owner;
    

    /**
     * Creates new form OkCancelDialog
     * @return 
     */
    
    public static OkCancelDialog edit(Window owner) {
        return new OkCancelDialog(owner);
    }
    
    public OkCancelDialog build() {
        init();
        return this;
    }
    
    
  
     public OkCancelDialog setOriginal(JComponent component) {
        this.original = component;
        return this;
    }
      
      public OkCancelDialog setOkLabel(String okLabel) {
        this.okLabel = okLabel;
        return this;
    } 
    
    public OkCancelDialog(Window owner) {
        super(owner);
        this.owner = owner;
    }
    
    public OkCancelDialog(Window owner, JComponent component) {
        this(owner);
        this.original = component;
        init();
    }

    private void init() {
        setModal(true);
        this.component = new JScrollPane(original);
        initComponents();
        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
        if(original instanceof Acceptable) {
            //resize (minimum size) window to fit jLabel
            Dimension d = new Dimension(480, (int) getMinimumSize().getHeight());
            setMinimumSize(d);
        }
        if(owner != null) {
            Dimension d = new Dimension(getParent().getWidth() * 80 / 100, getParent().getHeight() * 80 / 100);
            setMaximumSize(d);
            addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    System.out.println("" + getWidth());
                    if(getWidth() > getMaximumSize().getWidth()) {
                        setSize((int) getMaximumSize().getWidth(), getHeight());
                    }
                    else if(getHeight() > getMaximumSize().getHeight()) {
                        setSize(getWidth(), (int) getMaximumSize().getHeight());
                    }
                    super.componentResized(e); //To change body of generated methods, choose Tools | Templates.
                }

            });
        }
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        
        jLabel1.setText("<html>Please fill the required feilds marked by (<font color=\"red\">*</font>).</html>");
        jLabel1.setVisible(false);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText(okLabel);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
//                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
//                        .addGap(0, 366, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                        .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                    .addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
    }// </editor-fold>                        

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(original instanceof Acceptable) {
            if(((Acceptable) original).isAcceptable()) {
                doClose(RET_OK);
            }
            else {
                jLabel1.setVisible(true);
                Window window = SwingUtilities.getWindowAncestor(original);
                if(window!=null)
                {
                    window.pack();
                }
                
            }
        }
        else {
            doClose(RET_OK);
        }
    }                                        

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        doClose(RET_CANCEL);
    }                                            

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {                             
        doClose(RET_CANCEL);
    }                            
    
    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   

    private int returnStatus = RET_CANCEL;
}
