package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import client.bean.CrudCheck;
import client.gui.crudPanel.BlockCrudPanel;
import client.gui.crudPanel.CustomerCrudPanel;
import client.gui.crudPanel.ProjectCrudPanel;
import client.gui.normalPanel.ContractPanel;
import client.gui.window.WindowUtils;
import client.rmiclient.classes.crud.BeanComplexElement;
import client.rmiclient.classes.crud.ExtendedCrudPanel;
import client.rmiclient.classes.crud.ModelHolder;
import desktopadmin.model.accounting.Bank;
import desktopadmin.model.accounting.EnumType.Payer;

public class AppTest
{
	private BeanComplexElement beanComplexElement;


	public AppTest( )
	{
		// crudPanel.setPreferredSize(new Dimension(500, 500));
	
		
		List<Bank> banks = new ArrayList<Bank>();
		for(int i=1;i<=5;i++)
		{
			Bank bank = new Bank();
			bank.setId(Long.valueOf(i+""));
			bank.setName("Bank "+i);
			banks.add(bank);
		}
		
		beanComplexElement.addObjects("bank", banks);
		 
		 CustomerCrudPanel customerCrudPanel = new CustomerCrudPanel();
		 customerCrudPanel.lazyInitalize();
		 
		 ProjectCrudPanel projectCrudPanel = new ProjectCrudPanel();
		 projectCrudPanel.lazyInitalize();
		 
		 BlockCrudPanel blockCrudPanel = new BlockCrudPanel();
		 blockCrudPanel.lazyInitalize();
		 
		 TransactionPanel transactionPanel = new TransactionPanel(Payer.SUPPLIER);
		 transactionPanel.lazyInitalize();
		 
		 PaymentPanel paymentPanel = new PaymentPanel();
		 paymentPanel.lazyInitalize();
		 
		 ContractPanel contractPanel = new ContractPanel();
		 contractPanel.lazyInitalize();
		 
		WindowUtils.createDialog(null, "Check", transactionPanel);
	}

	public static void main(String[] args)
	{
		new AppTest();
	}

}
