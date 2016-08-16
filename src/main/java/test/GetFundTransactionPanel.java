package test;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JTabbedPane;

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


public class GetFundTransactionPanel extends TransactionPanel
{

	private static final long serialVersionUID = 1162579958949980922L;

	
	private JTabbedPane tabbedPane;
	
	public GetFundTransactionPanel()
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
		miscBuilder.append("Amount", txtAmount);
		
		//build er.append("Movement", comboPaymentMovement);
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
	
	/**
	 * we should create three transactions
	 * 1-Purchase transaction manadatory
	 * 2-Payment transaction if existing 
	 * 3-Stock transaction if existing
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
				
				//create purchase transaction
				Transaction purchaseTransaction = new SupplierTransaction();
				purchaseTransaction.setDescritpion(txtDescription.getText().trim());
				purchaseTransaction.setReferenceId(comboSupplier.getValue().getId());
				purchaseTransaction.setValue(txtAmount.getValue());
				purchaseTransaction.setTransactionType(TransactionType.FUND);
				//purchaseTransaction.setPaymentCause(comboTransactionCause.getValue());
				purchaseTransaction.setPayer(payer);
				purchaseTransaction.setNote(txtAreaNote.getText().trim());
				purchaseTransaction.setProject(DataUtils.getSelectedProject());
				purchaseTransaction.setCreationDate(new Date());
				
				transactions.add(purchaseTransaction);
				
				if ( !paymentPanel.isEmpty())
				{
					// create payment transaction
					Transaction paymentTransaction = paymentPanel.getTransaction(new SupplierTransaction());
					paymentTransaction.setDescritpion("PAYMENT " + paymentTransaction.getValue());
					paymentTransaction.setReferenceId(comboSupplier.getValue().getId());
					paymentTransaction.setValue(paymentTransaction.getValue());
					paymentTransaction.setTransactionType(TransactionType.FUND_PAYMENT);
					//paymentTransaction.setPaymentCause(comboTransactionCause.getValue());
					paymentTransaction.setPayer(payer);
					paymentTransaction.setNote(txtAreaNote.getText().trim());
					paymentTransaction.setProject(DataUtils.getSelectedProject());
					paymentTransaction.setCreationDate(new Date());
					transactions.add(paymentTransaction);

				}
				
				App.getCrudService().saveOrUpdate(transactions);

				return null;
			}

			@Override
			public void onDone(Void response)
			{
				MessageUtils.showInfoMessage(GetFundTransactionPanel.this, "Data has been saved successfully");

			}
		}, this);

	}
	
	

}
