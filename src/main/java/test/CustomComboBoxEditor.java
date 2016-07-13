package test;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;

import desktopadmin.model.accounting.Bank;
import desktopadmin.model.accounting.payment.Check;

@SuppressWarnings({
"rawtypes", "serial"
})
class CustomComboBoxEditor extends DefaultCellEditor
{

	// Declare a model that is used for adding the elements to the `ComboBox`

	private DefaultComboBoxModel model;


	public CustomComboBoxEditor(JComboBox comboBox)
	{
		super(comboBox);
		this.model = (DefaultComboBoxModel) ( (JComboBox) getComponent() ).getModel();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
	{

		if (column == 6)
		{
			Bank bank = (Bank) table.getValueAt(row, 5);
			model.removeAllElements();
			if (bank != null)
			{
				for (Check check : DataUtils.getChecks(bank))
				{
					model.addElement(check);
				}
			}

		}

		return super.getTableCellEditorComponent(table, value, isSelected, row, column);
	}
}