/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rmiclient.classes.crud;

import java.awt.Window;
import javax.swing.JComponent;
import javax.swing.JDialog;

/**
 *
 * @author User
 */
public class DialogUtilities {
    public static int RESULT_OK = 1;
    public static int RESULT_CANCEL = 2;
    public static int showOkCancelDialog(Window parent, JComponent component, String title) {
        OkCancelDialog dialog = new OkCancelDialog(parent, component);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle(title);
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
        if(dialog.getReturnStatus() == OkCancelDialog.RET_OK) {
            return RESULT_OK;
        }
        else {
            return RESULT_CANCEL;
        }
    }
    
     public static int showOkCancelDialog(Window parent, JComponent component, String title,String okLabel) {
        OkCancelDialog dialog = OkCancelDialog.edit(parent).setOriginal(component).setOkLabel(okLabel).build();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setTitle(title);
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
        if(dialog.getReturnStatus() == OkCancelDialog.RET_OK) {
            return RESULT_OK;
        }
        else {
            return RESULT_CANCEL;
        }
    }
}
