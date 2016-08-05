package test;
import java.util.Arrays;

import javax.swing.JSplitPane;

import client.App;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.model.accounting.SupplierTransaction;
import desktopadmin.model.accounting.Transaction;
import desktopadmin.model.accounting.TransactionCause;
import desktopadmin.model.accounting.EnumType.TransactionType;


public class SupplierTransactionPanel extends TransactionPanel
{

	private static final long serialVersionUID = 1162579958949980922L;

	private StockPanel stockPanel;
	
	@Override
	public void initComponents( )
	{
		super.initComponents();
		
		stockPanel = new StockPanel();
		stockPanel.lazyInitalize();
		
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

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(stockPanel);
		splitPane.setRightComponent(paymentPanel);
		builder.append(splitPane,col);
		//builder.append(paymentPanel, col);

		builder.appendSeparator();
		builder.append(ButtonBarFactory.buildRightAlignedBar(btnSave, btnClose), col);

	}

	@Override
	protected void save( )
	{
		ProgressBar.execute(new ProgressBarListener<Void>()
		{

			@Override
			public Void onBackground( ) throws Exception
			{

				Transaction transaction = paymentPanel.getTransaction(new SupplierTransaction());

				stockPanel.getTransaction(transaction);
				
				TransactionCause transactionCause = new TransactionCause();
				transactionCause.setId(Long.valueOf(1 + ""));
				transaction.setPaymentCause(transactionCause);

				transaction.setReferenceId(comboSupplier.getValue().getId());

				transaction.setDescritpion(txtDescription.getText().trim());

				// DoubleStream mapToDouble =
				// transaction.getPayments().stream().mapToDouble(ee->ee.getValue());
				transaction.setTransactionType(TransactionType.PAYMENT);

				transaction.setProject(DataUtils.getSelectedProject());

				App.getCrudService().saveOrUpdate(Arrays.asList(transaction));

				return null;
			}

			@Override
			public void onDone(Void response)
			{
				MessageUtils.showInfoMessage(SupplierTransactionPanel.this, "Data has been saved successfully");

			}
		}, this);

	}

}
