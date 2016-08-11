package client.gui.mainPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import test.DataUtils;
import test.PaymentPanel;
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
import desktopadmin.action.bean.ContractEntry;
import desktopadmin.action.bean.Entry;
import desktopadmin.model.accounting.CustomerTransaction;
import desktopadmin.model.accounting.EnumType.TransactionType;
import desktopadmin.model.sold.Contract;

public class CustomerTransactionPanel extends JpanelTemplate implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7560157209328224225L;



	private JTextField txtDescription;


//	private ExCombo<TransactionType> comboPaymentMovement;

	private ExCombo<Entry> comboCustomer;
	
	private ExCombo<ContractEntry> comboContract;



	private JTextArea txtAreaNote;


	private PaymentPanel paymentPanel;
	

	private JButton btnSave;

	private JButton btnClose;


	private Map<Long, List<ContractEntry>> contractEntryByCustomer;
	

	public CustomerTransactionPanel()
	{
	}

	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("p,10dlu,fill:150:grow"), this);
		builder.setDefaultDialogBorder();

		int col = builder.getColumnCount();

		builder.appendSeparator("Payment");

		builder.append("Customer", comboCustomer);
		builder.append("Contract", comboContract);
		builder.append("Description", txtDescription);
	//	builder.append("Movement", comboPaymentMovement);
		builder.append("Note", txtAreaNote);

		builder.append(paymentPanel, col);

		builder.appendSeparator();
		builder.append(ButtonBarFactory.buildRightAlignedBar(btnSave, btnClose), col);

	}

	@Override
	public void initComponents( )
	{

		paymentPanel = new PaymentPanel();
		paymentPanel.setVisibleRowCount(8);
		paymentPanel.lazyInitalize();
		// init data



		txtDescription = new JTextField();


		//comboPaymentMovement = new ExCombo<TransactionType>(TransactionType.values());

		comboCustomer = new ExCombo<>();
		comboCustomer.addItemListener(e->{
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				if (comboCustomer.getValue() != null)
				{
					List<ContractEntry> list = contractEntryByCustomer.get(comboCustomer.getValue().getId());
					if (list != null)
					{
						comboContract.setValues(list);
					}
				}
				else
				{
					comboContract.setValues(new ArrayList<>());
				}
			}
		});

		comboContract = new ExCombo<>();
		


		txtAreaNote = new JTextArea(5, 5);


		btnSave = ButtonFactory.createBtnSave();
		btnSave.addActionListener(this);

		btnClose = ButtonFactory.createBtnClose();
		btnClose.addActionListener(this);
		
		
		fillValues();
	}
	
	private void fillValues()
	{
		ProgressBar.execute(new ProgressBarListener<ContractBean>()
		{

			@Override
			public ContractBean onBackground( ) throws Exception
			{
				return App.getCrudService().getContractBean(DataUtils.getSelectedProject().getId());
			}
			

			@Override
			public void onDone(ContractBean response)
			{
				contractEntryByCustomer = response.getContracts().stream().collect(Collectors.groupingBy(e->e.getCustomerId()));
				
				comboCustomer.setValues(true,response.getCustomers());
				
				
			}
		}, this);
	}



	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnSave)
		{
			save();
		}
		else if(e.getSource()==btnClose)
		{
			closeWindow();
		}
	}

	private void save( )
	{
		ProgressBar.execute(new ProgressBarListener<Void>()
		{

			@Override
			public Void onBackground( ) throws Exception
			{
				
				CustomerTransaction transaction = (CustomerTransaction) paymentPanel.getTransaction(new CustomerTransaction());
				
				
				transaction.setReferenceId(comboCustomer.getValue().getId());
				transaction.setDescritpion(txtDescription.getText().trim());
				transaction.setTransactionType(TransactionType.PAYMENT_RECEIPT);
				transaction.setProject(DataUtils.getSelectedProject());
				transaction.setContract(new Contract(comboContract.getValue().getId()));
				transaction.setNote(txtAreaNote.getText());
				transaction.setCreationDate(new Date());
				
				App.getCrudService().saveOrUpdate(Arrays.asList(transaction));
				
				return null;
			}

			@Override
			public void onDone(Void response)
			{
				MessageUtils.showInfoMessage(CustomerTransactionPanel.this, "Data has been saved successfully");
				
			}
		}, this);

	}

}
