package test;


import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTable;

import client.gui.table.utils.TableUtils;

public class NextCellActioin extends AbstractAction{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5170761623416795215L;
	private JTable jTable1;
    private PaymentTableModel tableModel;
    
	public NextCellActioin(JTable jTable,PaymentTableModel paymentTableModel) {
        this.jTable1 = jTable;
        this.tableModel = paymentTableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
       if(jTable1.isEditing())
       {
           jTable1.getCellEditor().stopCellEditing();
       }
      tableModel.addRow(new PaymentBean());
      TableUtils.moveToBottom(jTable1);

    }
}