package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.App;
import client.gui.button.ButtonFactory;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.utils.ExCombo;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.action.bean.ContractBean;
import desktopadmin.action.bean.Entry;
import desktopadmin.model.accounting.CustomerTransaction;
import desktopadmin.model.accounting.EnumType.Payer;
import desktopadmin.model.accounting.EnumType.PaymentMovement;
import desktopadmin.model.accounting.Transaction;
import desktopadmin.model.accounting.TransactionCause;

public class TransactionPanel extends JpanelTemplate implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7560157209328224225L;


	

	private JTextField txtDescription;

	private ExCombo<PaymentMovement> comboPaymentMovement;

	private JCheckBox cbCompany;
	
	private ExCombo<Entry> comboSupplier;

	private ExCombo<TransactionCause> comboTransactionCause;

	private List<Entry> suppliers;

	private List<Entry> companies;

	private JTextArea txtAreaNote;

	private PaymentPanel paymentPanel;

	private JButton btnSave;

	private JButton btnClose;

	// holders
	private List<TransactionCause> transactionCauses;

	private Payer payer;

	public TransactionPanel( )
	{
		this.payer = Payer.SUPPLIER;
	}

	public TransactionPanel(Payer payer)
	{
		this.payer = Payer.SUPPLIER;
	}

	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("p,10dlu,fill:150:grow"), this);
		builder.setDefaultDialogBorder();

		int col = builder.getColumnCount();

		builder.appendSeparator("Payment");

		builder.append(cbCompany,col);
		builder.append("Supplier", comboSupplier);
		builder.append("Description", txtDescription);
		
		builder.append("Movement", comboPaymentMovement);
		builder.append("Transaction Cause", comboTransactionCause);
		builder.append("Note", txtAreaNote);

		builder.append(paymentPanel, col);

		builder.appendSeparator();
		builder.append(ButtonBarFactory.buildRightAlignedBar(btnSave, btnClose), col);

	}

	@Override
	public void initComponents( )
	{

		paymentPanel = new PaymentPanel();
		paymentPanel.lazyInitalize();

		// init data
		transactionCauses = DataUtils.transactionCauses(payer);


		txtDescription = new JTextField();

		comboPaymentMovement = new ExCombo<PaymentMovement>(PaymentMovement.values());

		comboSupplier = new ExCombo<>();

		comboTransactionCause = new ExCombo<TransactionCause>(transactionCauses);

		txtAreaNote = new JTextArea(5, 5);

		btnSave = ButtonFactory.createBtnSave();
		btnSave.addActionListener(this);

		btnClose = ButtonFactory.createBtnCancel();
		btnClose.addActionListener(this);
		
		cbCompany = new JCheckBox("Is Company");
		cbCompany.addItemListener(e->{
			if(cbCompany.isSelected())
			{
				comboSupplier.setValues(companies);
			}
			else
			{
				comboSupplier.setValues(suppliers);
			}
		});

		fillValues();
	}

	private void fillValues( )
	{
		ProgressBar.execute(new ProgressBarListener<ContractBean>()
		{

			@Override
			public ContractBean onBackground( ) throws Exception
			{
				return App.getCrudService().getSupplierContractBean(DataUtils.getSelectedProject().getId());
			}

			@Override
			public void onDone(ContractBean response)
			{
				suppliers = response.getSuppliers();
				companies = response.getCompanies();
				comboSupplier.setValues(response.getSuppliers());

			}
		}, this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnSave)
		{
			save();
		}
	}

	private void save( )
	{
		ProgressBar.execute(new ProgressBarListener<Void>()
		{

			@Override
			public Void onBackground( ) throws Exception
			{

				Transaction transaction = paymentPanel.getTransaction(new CustomerTransaction());

				TransactionCause transactionCause = new TransactionCause();
				transactionCause.setId(Long.valueOf(1 + ""));
				transaction.setPaymentCause(transactionCause);

				transaction.setReferenceId(comboSupplier.getValue().getId());

				transaction.setDescritpion(txtDescription.getText().trim());

				// DoubleStream mapToDouble =
				// transaction.getPayments().stream().mapToDouble(ee->ee.getValue());
				transaction.setPaymentMovement(PaymentMovement.PAYMENT);

				transaction.setProject(DataUtils.getSelectedProject());

				App.getCrudService().saveOrUpdate(Arrays.asList(transaction));

				return null;
			}

			@Override
			public void onDone(Void response)
			{
				MessageUtils.showInfoMessage(TransactionPanel.this, "Data has been saved successfully");

			}
		}, this);

	}

}
