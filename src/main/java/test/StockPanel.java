package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import org.jdesktop.swingx.JXTable;

import client.gui.button.ButtonFactory;
import client.gui.input.DoubleTextField;
import client.gui.table.utils.TableUtils;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.utils.ExCombo;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jidesoft.swing.AutoCompletionComboBox;

import desktopadmin.model.accounting.Bank;
import desktopadmin.model.accounting.EnumType.Currency;
import desktopadmin.model.accounting.Transaction;
import desktopadmin.model.accounting.payment.Check;
import desktopadmin.model.stock.Item;
import desktopadmin.model.stock.Product;

public class StockPanel extends JpanelTemplate implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7560157209328224225L;

	private JTextField txtValueDollars;

	private JTextField txtTotal;
	

	private AutoCompletionComboBox comboBanks;

	private ExCombo<Currency> comboCurrency;
	private ExCombo<Product> comboProduct;

	private ExCombo<Check> comboCheck;

	private JXTable table;

	private StockTableModel tableModel;

	private JButton btnAdd;

	private JButton btnDelete;

	private int visibleRowCount = 5;

	public StockPanel( )
	{
	}

	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("40dlu,10dlu,fill:150:grow"), this);
		builder.setDefaultDialogBorder();

		int col = builder.getColumnCount();

		builder.appendSeparator("Stock");
		
		builder.append("Total($)", txtTotal);

		builder.append(ButtonBarFactory.buildRightAlignedBar(btnAdd, btnDelete), col);
		
		JScrollPane scrollPane = new JScrollPane(table);
		builder.append(scrollPane, col);

	}

	@Override
	public void initComponents( )
	{


		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		
		// init components
		txtValueDollars = new JTextField();
		txtValueDollars.setEditable(false);

		comboCheck = new ExCombo<Check>();
		
		comboProduct = new ExCombo<>(DataUtils.getProducts());

		comboCurrency = new ExCombo<>(Currency.values());
		comboCurrency.setSelectedItem(Currency.DOLLAR);

		comboBanks = new AutoCompletionComboBox(DataUtils.banks().toArray());

		tableModel = new StockTableModel();

		table = new JXTable();
		table.setVisibleRowCount(visibleRowCount );
		table.putClientProperty("terminateEditOnFocusLost", true);
		//TableUtils.registerKeyboardAction(tablePayment, new NextCellActioin(tablePayment, stockTableModel), "Action.NextCell", KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), JComponent.WHEN_FOCUSED);

		table.setModel(tableModel);
		table.getModel().addTableModelListener(createTablePaymentModelListener());
		tableModel.fireTableDataChanged();
		setRendererAndEditor();

		btnAdd = ButtonFactory.createBtnAdd();
		btnAdd.addActionListener(this);

		btnDelete = ButtonFactory.createBtnDelete();
		btnDelete.addActionListener(this);

	}


	
	private void setRendererAndEditor( )
	{
		table.setRowHeight(25);
		table.setDefaultEditor(Double.class, new DefaultCellEditor(new DoubleTextField()));
		table.setDefaultEditor(Currency.class, new DefaultCellEditor(comboCurrency));
		table.setDefaultEditor(Product.class, new DefaultCellEditor(comboProduct));
		table.setDefaultEditor(Bank.class, new DefaultCellEditor(comboBanks));
		table.setDefaultEditor(Check.class, new CustomComboBoxEditor(comboCheck));
		
	}
	
	private TableModelListener createTablePaymentModelListener( )
	{
		return new TableModelListener()
		{

			@Override
			public void tableChanged(TableModelEvent e)
			{
				double total = 0;
				for (int i = 0; i < tableModel.getRowCount(); i++ )
				{
					Object valueAt = tableModel.getValueAt(i, StockTableModel.COL_SUB_TOTAL);
					if (valueAt instanceof Double)
					{
						total += (Double) valueAt;
					}
				}

				txtTotal.setText(total + "");

			}
		};
	}

	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnAdd)
		{
			tableModel.addRow(new Item());
		}
		else
		{
			if (e.getSource() == btnDelete)
			{
				tableModel.deleteRows(TableUtils.convertSelectedRowsToModel(table));
			}
		}

	}

	public Transaction getTransaction( Transaction transaction)
	{

		Set<Item> items = new HashSet<>(tableModel.getRows());
		for(Item item:items)
			item.setTransaction(transaction);

		transaction.setItems(items);
		
		return transaction;

	}

	public boolean isEmpty()
	{
		return tableModel.getRows().isEmpty();
	}
	
	public int getVisibleRowCount( )
	{
		return visibleRowCount;
	}

	public void setVisibleRowCount(int visibleRowCount)
	{
		this.visibleRowCount = visibleRowCount;
	}
	
	

}
