package client.gui.normalPanel;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.jdesktop.swingx.JXDatePicker;

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
import desktopadmin.model.accounting.EnumType.PaymentMovement;
import desktopadmin.model.accounting.EnumType.RealEstateType;
import desktopadmin.model.accounting.Transaction;
import desktopadmin.model.accounting.TransactionCause;
import desktopadmin.model.building.Block;
import desktopadmin.model.building.Project;
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
		JPanel panel = new JPanel();
		panel.add(comboProjects);
		panel.add(btnStart);
		builder.append("projects", panel);

		builder.append("Description", txtDescription);
		builder.append("Customers", comboCustomers);
		builder.append("Block", comboBlocks);
		builder.append("Real Estate Type", comboRealEstateType);
		builder.append("Real Estate", comboRealEstate);
		builder.append("Price($)", txtDprice);
		builder.append("Entilement Date", datePickerEntilement);

		builder.append(paymentPanel, builder.getColumnCount());

		builder.appendSeparator();
		builder.append(ButtonBarFactory.buildRightAlignedBar(btnSave), builder.getColumnCount());

	}

	@Override
	public void initComponents( )
	{
		paymentPanel = new PaymentPanel();
		paymentPanel.lazyInitalize();

		comboProjects = new ExCombo<>();
		fillProjects();

		txtDescription = new JTextArea(5, 5);

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

		btnSave.addActionListener(e -> {
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
					Transaction BuyinhPaymenttransaction = new CustomerTransaction();
					BuyinhPaymenttransaction.setValue(Long.valueOf(txtDprice.getText()));
					TransactionCause transactionCause = new TransactionCause();
					transactionCause.setId(Long.valueOf(3 + ""));
					BuyinhPaymenttransaction.setPaymentCause(transactionCause);

					BuyinhPaymenttransaction.setReferenceId(comboCustomers.getValue().getId());

					BuyinhPaymenttransaction.setDescritpion("Buying new Flat");
					BuyinhPaymenttransaction.setPaymentMovement(PaymentMovement.PURCHASE);

					BuyinhPaymenttransaction.setProject(comboProjects.getValue());

					// Down payment transaction
					Transaction downPaymenttransaction = paymentPanel.getTransaction(new CustomerTransaction());

					transactionCause = new TransactionCause();
					transactionCause.setId(Long.valueOf(1 + ""));
					downPaymenttransaction.setPaymentCause(transactionCause);

					downPaymenttransaction.setReferenceId(comboCustomers.getValue().getId());

					downPaymenttransaction.setDescritpion("Down Payment for Customer " + comboCustomers.getValue().getName() + "\n" + "because of buying a " + comboRealEstateType.getValue());
					DoubleStream mapToDouble = downPaymenttransaction.getPayments().stream().mapToDouble(ee -> ee.getValue());
					downPaymenttransaction.setPaymentMovement(PaymentMovement.PAYMENT);

					downPaymenttransaction.setProject(comboProjects.getValue());
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
		});

		btnStart = ButtonFactory.createBtnSearch();
		btnStart.addActionListener(createBtnStartActionListener());

		realEstateMap = new HashMap<>();

	}

	private ActionListener createBtnStartActionListener( )
	{
		return e -> {
			if (comboProjects.getValue() == null)
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
					return App.getCrudService().getContractBean(comboProjects.getValue().getId());
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
		};
	}

	private void fillProjects( )
	{
		ProgressBar.execute(new ProgressBarListener<List<Project>>()
		{

			@Override
			public List<Project> onBackground( ) throws Exception
			{
				return App.getCrudService().list(Project.class);
			}

			@Override
			public void onDone(List<Project> response)
			{

				comboProjects.setValues(true, response);
			}
		}, this);
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

	/**
	 * 
	 */
	private static final long serialVersionUID = -1097958139224574457L;

	private JTextArea txtDescription;

	private ExCombo<Entry> comboCustomers;

	private ExCombo<Project> comboProjects;

	private ExCombo<RealEstateType> comboRealEstateType;

	private ExCombo<Block> comboBlocks;

	private ExCombo<RealEstate> comboRealEstate;

	private DoubleTextField txtDprice;

	private JXDatePicker datePickerEntilement;

	private PaymentPanel paymentPanel;

	private JButton btnSave;

	private JButton btnStart;

}
