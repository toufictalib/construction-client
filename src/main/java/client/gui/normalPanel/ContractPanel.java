package client.gui.normalPanel;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JTextArea;

import org.apache.commons.lang3.StringUtils;
import org.jdesktop.swingx.JXDatePicker;

import test.DataUtils;
import test.PaymentPanel;
import client.App;
import client.gui.button.ButtonFactory;
import client.gui.input.DoubleTextField;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.utils.DefaultFormBuilderUtils;
import client.utils.ExCombo;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;

import desktopadmin.action.bean.ContractBean;
import desktopadmin.action.bean.Entry;
import desktopadmin.model.accounting.CustomerTransaction;
import desktopadmin.model.accounting.EnumType.Payer;
import desktopadmin.model.accounting.EnumType.RealEstateType;
import desktopadmin.model.accounting.EnumType.TransactionType;
import desktopadmin.model.accounting.Transaction;
import desktopadmin.model.building.Block;
import desktopadmin.model.building.RealEstate;
import desktopadmin.model.person.Customer;
import desktopadmin.model.sold.Contract;

public class ContractPanel extends JpanelTemplate
{

	private Map<Long/* block id */, Set<RealEstate>> realEstateMap;

	@Override
	public void init( )
	{
		DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("p,10dlu,fill:p:grow", this, false);
		builder.setDefaultDialogBorder();

		builder.appendSeparator("Contract");
		/*JPanel panel = new JPanel();
		panel.add(comboProjects);
		panel.add(btnStart);
		builder.append("projects", panel);*/

		builder.append("Description", txtDescription);
		builder.append("Customers", comboCustomers);
		builder.append("Block", comboBlocks);
		builder.append("Real Estate Type", comboRealEstateType);
		builder.append("Real Estate", comboRealEstate);
		builder.append("Price($)", txtDprice);
		builder.append("Entilement Date", datePickerEntilement);

		builder.append(paymentPanel, builder.getColumnCount());

		builder.appendSeparator();
		builder.append(ButtonBarFactory.buildRightAlignedBar(btnSave,btnClose), builder.getColumnCount());

	}

	@Override
	public void initComponents( )
	{
		paymentPanel = new PaymentPanel();
		paymentPanel.lazyInitalize();


		txtDescription = new JTextArea(3, 5);

		comboCustomers = new ExCombo<>();

		comboBlocks = new ExCombo<>();

		comboRealEstate = new ExCombo<>();

		comboRealEstateType = new ExCombo<RealEstateType>(RealEstateType.values());
		comboRealEstateType.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED)
			{
				fillRealEstateCombo();
			}

		});

		txtDprice = new DoubleTextField();

		datePickerEntilement = new JXDatePicker();

		btnSave = ButtonFactory.createBtnSave();

		btnSave.addActionListener(createBtnSaveActionListener());

		btnStart = ButtonFactory.createBtnSearch();
		btnStart.addActionListener(createBtnStartActionListener());
		
		btnClose = ButtonFactory.createBtnClose();
		btnClose.addActionListener(e->{
			closeWindow();
		});

		realEstateMap = new HashMap<>();

		
		fillValues();
	}

	

	private void fillRealEstateCombo( )
	{
		Block selectedBlock = comboBlocks.getValue();
		if (selectedBlock != null)
		{
			RealEstateType realEstateType = comboRealEstateType.getValue();
			if (realEstateType != null)
			{
				Set<RealEstate> estates = realEstateMap.get(selectedBlock.getId());
				if (estates == null)
				{
					estates = new HashSet<>();
				}

				estates = estates.stream().filter(e -> realEstateType.toDiscriminator().equals(e.getDiscriminatorValue())).collect(Collectors.toSet());

				comboRealEstate.setValues(estates);
			}
		}

	}
	
	
	private void checkValidation() throws Exception
	{
		StringBuilder builder = new StringBuilder();
		if(StringUtils.isEmpty(txtDescription.getText()))
		{
			builder.append("Add Description\n");
		}
		
		if(builder.length()>0)
			throw new Exception(builder.toString());
	}
	/**
	 * 
	 * @return
	 */
	private ActionListener createBtnSaveActionListener( )
	{
		
		return e -> {
			

			try
			{
				checkValidation();
			}
			catch (Exception ex)
			{
				MessageUtils.showErrorMessage(ContractPanel.this, ex.getMessage());
				return;
			}
			
			ProgressBar.execute(new ProgressBarListener<Void>()
			{

				@Override
				public Void onBackground( ) throws Exception
				{

					Contract contract = new Contract();

					Customer customer = new Customer();
					customer.setId(comboCustomers.getValue().getId());
					contract.setCustomer(customer);

					contract.setDescription(txtDescription.getText().trim());
					contract.setEntilementDate(datePickerEntilement.getDate());
					contract.setPrice(txtDprice.getValue());
					contract.setRealEstate(comboRealEstate.getValue());

					ContractBean contractBean = new ContractBean();

					// Buying transaction
					CustomerTransaction BuyinhPaymenttransaction = new CustomerTransaction();
					BuyinhPaymenttransaction.setValue(Long.valueOf(txtDprice.getText()));
					BuyinhPaymenttransaction.setReferenceId(comboCustomers.getValue().getId());
					BuyinhPaymenttransaction.setValue(txtDprice.getValue());
					BuyinhPaymenttransaction.setTransactionType(TransactionType.PURCHASE_REAL_ESTATE);
					BuyinhPaymenttransaction.setProject(DataUtils.getSelectedProject());
					BuyinhPaymenttransaction.setContract(contract);
					BuyinhPaymenttransaction.setDescritpion("Buy new Real Estate : "+contract.getDescription()+" for "+BuyinhPaymenttransaction.getValue());
					BuyinhPaymenttransaction.setCreationDate(new Date());

					// Down payment transaction
					CustomerTransaction downPaymenttransaction = (CustomerTransaction) paymentPanel.getTransaction(new CustomerTransaction());
					downPaymenttransaction.setReferenceId(comboCustomers.getValue().getId());
					downPaymenttransaction.setTransactionType(TransactionType.PAYMENT_DOWN);
					downPaymenttransaction.setDescritpion("Down Payment (Customer " + comboCustomers.getValue().getName() +" for buying "+comboRealEstateType.getValue());
					downPaymenttransaction.setTransactionType(TransactionType.PAYMENT_DOWN);
					downPaymenttransaction.setProject(DataUtils.getSelectedProject());
					downPaymenttransaction.setPayer(Payer.CUSTOMER);
					downPaymenttransaction.setCreationDate(new Date());
					downPaymenttransaction.setContract(contract);
					
					contractBean.setContract(contract);
					
					List<Transaction> transactions = new ArrayList<>();
					transactions.add(BuyinhPaymenttransaction);
					transactions.add(downPaymenttransaction);
					
					contractBean.setTransactions(transactions);

					App.getCrudService().saveContract(contractBean);

					return null;
				}

				@Override
				public void onDone(Void response)
				{
					MessageUtils.showInfoMessage(ContractPanel.this, "Data has been saved successfully");
				}

			}, this);
		};
	}

	private ActionListener createBtnStartActionListener( )
	{
		return e -> {
			fillValues();
		};
	}

	private void fillValues( )
	{
		if (DataUtils.getSelectedProject() == null)
		{
			MessageUtils.showWarningMessage(ContractPanel.this, "Please select a project");
			return;
		}

		// init real estate map on select project
		realEstateMap.clear();

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

				comboCustomers.setValues(false, response.getCustomers());
				comboBlocks.setValues(false, response.getBlocks());

				for (Block block : response.getBlocks())
				{
					realEstateMap.put(block.getId(), new HashSet<>(block.getFlats()));
				}

				fillRealEstateCombo();
			}

		}, this);
	}

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1097958139224574457L;

	private JTextArea txtDescription;

	private ExCombo<Entry> comboCustomers;


	private ExCombo<RealEstateType> comboRealEstateType;

	private ExCombo<Block> comboBlocks;

	private ExCombo<RealEstate> comboRealEstate;

	private DoubleTextField txtDprice;

	private JXDatePicker datePickerEntilement;

	private PaymentPanel paymentPanel;

	private JButton btnSave;

	private JButton btnClose;

	private JButton btnStart;

}
