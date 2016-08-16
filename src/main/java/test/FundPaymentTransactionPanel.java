package test;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTabbedPane;

import org.hibernate.bytecode.buildtime.spi.ExecutionException;

import client.App;
import client.utils.ComponentUtils;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.action.bean.ContractBean;
import desktopadmin.model.accounting.EnumType.TransactionType;
import desktopadmin.model.accounting.SupplierTransaction;
import desktopadmin.model.accounting.Transaction;


public class FundPaymentTransactionPanel extends TransactionPanel
{

	private static final long serialVersionUID = 1162579958949980922L;

	
	private JTabbedPane tabbedPane;
	
	public FundPaymentTransactionPanel( )
	{
		super();
	}
	
	@Override
	public void initComponents( )
	{
		super.initComponents();
		
		
		tabbedPane = new JTabbedPane();
	}
	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("p,10dlu,fill:150:grow"), this);
		builder.setDefaultDialogBorder();
		
		DefaultFormBuilder miscBuilder = new DefaultFormBuilder(new FormLayout("p,10dlu,fill:150:grow"));

		int col = builder.getColumnCount();

		miscBuilder.appendSeparator("Payment");

		miscBuilder.append("Funders", comboSupplier);
		miscBuilder.append("Description", txtDescription);
		
		//builder.append("Movement", comboPaymentMovement);
		//miscBuilder.append("Transaction Cause", comboTransactionCause);
		miscBuilder.append("Note", txtAreaNote);

		tabbedPane.addTab("Misc",miscBuilder.getPanel());
		tabbedPane.addTab("Payment",paymentPanel);
		/*JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setLeftComponent(stockPanel);
		splitPane.setRightComponent(paymentPanel);*/
		builder.append(tabbedPane,col);
		//builder.append(paymentPanel, col);

		builder.appendSeparator();
		builder.append(ButtonBarFactory.buildRightAlignedBar(btnSave, btnClose), col);

		this.setPreferredSize(new Dimension(ComponentUtils.getDimension(60, 60)));
	}

	protected void fillValues( )
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
				comboSupplier.setValues(response.getFunders());

			}
		}, this);
	}
	
	protected void checkValidation( ) throws Exception
	{
		super.checkValidation();
		
		if(paymentPanel.isEmpty())
		{
			throw new ExecutionException("Select at least one payment way");
		}
	}
	/**
	 * we should create one transaction
	 * 1-Payment transaction manadatory 
	 */
	@Override
	protected void save( )
	{
		
		try
		{
			checkValidation();
		}
		catch (Exception e)
		{
			MessageUtils.showErrorMessage(this, e.getMessage());
			return;
		}
		
		ProgressBar.execute(new ProgressBarListener<Void>()
		{

			@Override
			public Void onBackground( ) throws Exception
			{
				
				List<Transaction> transactions = new ArrayList<>();
				
				
					// create payment transaction
					Transaction paymentTransaction = paymentPanel.getTransaction(new SupplierTransaction());
					paymentTransaction.setDescritpion("PAYMENT " + paymentTransaction.getValue());
					paymentTransaction.setReferenceId(comboSupplier.getValue().getId());
					paymentTransaction.setValue(paymentTransaction.getValue());
					paymentTransaction.setTransactionType(TransactionType.FUND_RETURN_PAYMENT);
					//paymentTransaction.setPaymentCause(comboTransactionCause.getValue());
					paymentTransaction.setPayer(payer);
					paymentTransaction.setNote(txtAreaNote.getText().trim());
					paymentTransaction.setProject(DataUtils.getSelectedProject());
					paymentTransaction.setCreationDate(new Date());
					
					
					
					transactions.add(paymentTransaction);

				


				App.getCrudService().saveOrUpdate(transactions);

				return null;
			}

			@Override
			public void onDone(Void response)
			{
				MessageUtils.showInfoMessage(FundPaymentTransactionPanel.this, "Data has been saved successfully");

			}
		}, this);

	}

}
