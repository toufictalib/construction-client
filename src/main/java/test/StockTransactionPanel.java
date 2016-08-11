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

import desktopadmin.model.accounting.EnumType.TransactionType;
import desktopadmin.model.accounting.SupplierTransaction;
import desktopadmin.model.accounting.Transaction;

public class StockTransactionPanel extends TransactionPanel
{

	private static final long serialVersionUID = 1162579958949980922L;

	private StockPanel stockPanel;

	private JTabbedPane tabbedPane;

	public StockTransactionPanel()
	{
		super();
	}

	@Override
	public void initComponents( )
	{
		super.initComponents();

		stockPanel = new StockPanel();
		stockPanel.lazyInitalize();

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

		miscBuilder.append(cbCompany, col);
		miscBuilder.append("Supplier", comboSupplier);
		miscBuilder.append("Description", txtDescription);

		// builder.append("Movement", comboPaymentMovement);
		//miscBuilder.append("Transaction Cause", comboTransactionCause);
		miscBuilder.append("Note", txtAreaNote);

		tabbedPane.addTab("Misc", miscBuilder.getPanel());
		tabbedPane.addTab("Stock", stockPanel);
		/*
		 * JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		 * splitPane.setLeftComponent(stockPanel);
		 * splitPane.setRightComponent(paymentPanel);
		 */
		builder.append(tabbedPane, col);
		// builder.append(paymentPanel, col);

		builder.appendSeparator();
		builder.append(ButtonBarFactory.buildRightAlignedBar(btnSave, btnClose), col);

		this.setPreferredSize(new Dimension(ComponentUtils.getDimension(60, 60)));
	}

	@Override
	protected void checkValidation( ) throws Exception
	{
		// TODO Auto-generated method stub
		super.checkValidation();

		if ( stockPanel.isEmpty())
		{
			throw new Exception("Select at least one stock item");
		}
	}

	/**
	 * we should create three transactions 1-Purchase transaction manadatory
	 * 2-Payment transaction if existing 3-Stock transaction if existing
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

				// create stock transaction
				Transaction stockTransaction = stockPanel.getTransaction(new SupplierTransaction());
				stockTransaction.setDescritpion("STOCK");
				stockTransaction.setReferenceId(comboSupplier.getValue().getId());
				stockTransaction.setTransactionType(TransactionType.STOCK_RECEIVED);
				//stockTransaction.setPaymentCause(comboTransactionCause.getValue());
				stockTransaction.setPayer(payer);
				stockTransaction.setProject(DataUtils.getSelectedProject());
				stockTransaction.setCreationDate(new Date());

				transactions.add(stockTransaction);

				App.getCrudService().saveOrUpdate(transactions);

				return null;
			}

			@Override
			public void onDone(Void response)
			{
				MessageUtils.showInfoMessage(StockTransactionPanel.this, "Data has been saved successfully");

			}
		}, this);

	}

}
