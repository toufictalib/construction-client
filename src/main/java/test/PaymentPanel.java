package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
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
import desktopadmin.model.accounting.EnumType.PaymentType;
import desktopadmin.model.accounting.Transaction;
import desktopadmin.model.accounting.payment.Check;
import desktopadmin.model.accounting.payment.Payment;
import desktopadmin.model.accounting.payment.PaymentCash;
import desktopadmin.model.accounting.payment.PaymentCheck;

public class PaymentPanel extends JpanelTemplate implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7560157209328224225L;

	private JTextField txtValueDollars;

	private JTextField txtTotal;

	

	private AutoCompletionComboBox comboBanks;

	private ExCombo<Currency> comboCurrency;

	private ExCombo<Check> comboCheck;

	private JXTable tablePayment;

	private PaymentTableModel paymentTableModel;

	private JButton btnAdd;

	private JButton btnDelete;

	private int visibleRowCount = 5;

	public PaymentPanel( )
	{
	}

	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("40dlu,10dlu,fill:150:grow"), this);
		builder.setDefaultDialogBorder();

		int col = builder.getColumnCount();

		builder.appendSeparator("Payment");
		
		builder.append("Total($)", txtTotal);

		builder.append(ButtonBarFactory.buildRightAlignedBar(btnAdd, btnDelete), col);
		
		JScrollPane scrollPane = new JScrollPane(tablePayment);
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

		comboCurrency = new ExCombo<>(Currency.values());
		comboCurrency.setSelectedItem(Currency.DOLLAR);

		comboBanks = new AutoCompletionComboBox(DataUtils.banks().toArray());

		paymentTableModel = new PaymentTableModel();

		tablePayment = new JXTable();
		tablePayment.setVisibleRowCount(visibleRowCount );
		tablePayment.putClientProperty("terminateEditOnFocusLost", true);
		TableUtils.registerKeyboardAction(tablePayment, new NextCellActioin(tablePayment, paymentTableModel), "Action.NextCell", KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), JComponent.WHEN_FOCUSED);

		tablePayment.setModel(paymentTableModel);
		tablePayment.getModel().addTableModelListener(createTablePaymentModelListener());
		paymentTableModel.fireTableDataChanged();
		setRendererAndEditor();

		btnAdd = ButtonFactory.createBtnAdd();
		btnAdd.addActionListener(this);

		btnDelete = ButtonFactory.createBtnDelete();
		btnDelete.addActionListener(this);

	}

	private TableModelListener createTablePaymentModelListener( )
	{
		return new TableModelListener()
		{

			@Override
			public void tableChanged(TableModelEvent e)
			{
				double total = 0;
				for (PaymentBean paymentBean : paymentTableModel.getRows())
				{
					total += paymentBean.getConvertedValue();
				}

				txtTotal.setText(total + "");

			}
		};
	}

	private void setRendererAndEditor( )
	{
		tablePayment.setRowHeight(25);
		tablePayment.setDefaultEditor(Double.class, new DefaultCellEditor(new DoubleTextField()));
		tablePayment.setDefaultEditor(Currency.class, new DefaultCellEditor(comboCurrency));
		tablePayment.setDefaultEditor(PaymentType.class, new DefaultCellEditor(new ExCombo<>(PaymentType.values())));
		tablePayment.setDefaultEditor(Bank.class, new DefaultCellEditor(comboBanks));
		tablePayment.setDefaultEditor(Check.class, new CustomComboBoxEditor(comboCheck));
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnAdd)
		{
			paymentTableModel.addRow(new PaymentBean());
		}
		else
		{
			if (e.getSource() == btnDelete)
			{
				paymentTableModel.deleteRows(TableUtils.convertSelectedRowsToModel(tablePayment));
			}
		}

	}

	public Transaction getTransaction( Transaction transaction)
	{

		Set<Payment> payments = new HashSet<Payment>();
		for (PaymentBean paymentBean : paymentTableModel.getRows())
		{
			Payment payment = null;
			switch (paymentBean.getPaymentType())
			{
				case CASH:
					payment = new PaymentCash();
					break;
				case INNER_CHECK:
				case CHECK:
					PaymentCheck paymentCheck = new PaymentCheck(paymentBean.getPaymentType());
					paymentBean.getCheck().setBank(paymentBean.getBank());
					paymentCheck.setCheck(paymentBean.getCheck());
					payment = paymentCheck;
					break;

				default:
					break;
			}
			
			payment.setCurrency(paymentBean.getCurrency());
			payment.setDollarPrice(paymentBean.getDollarPrice());
			payment.setPaymentType(paymentBean.getPaymentType());
			payment.setTransaction(transaction);
			payment.setValue(paymentBean.getValue());
			payment.setBank(paymentBean.getBank());

			payments.add(payment);
		}

		transaction.setValue(Double.parseDouble(txtTotal.getText()));
		transaction.setPayments(payments);
		
		return transaction;

	}

	public int getVisibleRowCount( )
	{
		return visibleRowCount;
	}

	public void setVisibleRowCount(int visibleRowCount)
	{
		this.visibleRowCount = visibleRowCount;
	}
	
	public boolean isEmpty()
	{
		return paymentTableModel.getRowCount()==0;
	}

}
