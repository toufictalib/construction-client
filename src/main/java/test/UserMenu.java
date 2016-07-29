package test;

import javax.swing.JPanel;

import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.RibbonElementPriority;

import client.gui.crudPanel.BlockCrudPanel;
import client.gui.crudPanel.CheckCrudPanel;
import client.gui.crudPanel.CompanyCrudPanel;
import client.gui.crudPanel.CustomerCrudPanel;
import client.gui.crudPanel.FlatCrudPanel;
import client.gui.crudPanel.SupplierCrudPanel;
import client.gui.mainPanels.CustomerTransactionPanel;
import client.gui.mainPanels.ProjectElementsPanel;
import client.gui.normalPanel.ContractPanel;
import client.gui.normalPanel.StatisticsPanel;
import client.rmiclient.classes.crud.JpanelTemplate;

public class UserMenu
{
	public static void drawUserMenu(JPanel myPanel, JRibbonBand band1)
	{
		JCommandButton button1 = new JCommandButton("Customer", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_app_kthememgr.png"));
		JCommandButton button2 = new JCommandButton("Supplier", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_app_ksame.png"));
		JCommandButton button3 = new JCommandButton("Company", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_app_error.png"));

		band1.addCommandButton(button1, RibbonElementPriority.TOP);
		band1.addCommandButton(button2, RibbonElementPriority.MEDIUM);
		band1.addCommandButton(button3, RibbonElementPriority.MEDIUM);

		button1.addActionListener(e -> {
			buildPanel(myPanel,new CustomerCrudPanel());
		});

		button2.addActionListener(e -> {
			buildPanel(myPanel,new SupplierCrudPanel());
		});

		button3.addActionListener(e -> {
			buildPanel(myPanel,new CompanyCrudPanel());
		});

	}
	
	
	public static void drawTransactions(JPanel myPanel, JRibbonBand band1)
	{
		JCommandButton btnCheck = new JCommandButton("Check", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_action_bookmark.png"));
		JCommandButton btnTransactionCustomer = new JCommandButton("Customer Transaction", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_app_ksame.png"));
		JCommandButton btnTransactionSupplier = new JCommandButton("Supplier Transaction", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_app_kthememgr.png"));
		JCommandButton btnContract = new JCommandButton("Contract", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_action_bookmark.png"));

		band1.addCommandButton(btnCheck, RibbonElementPriority.TOP);
		/*band1.addCommandButton(btnTransactionCustomer, RibbonElementPriority.MEDIUM);
		band1.addCommandButton(btnTransactionSupplier, RibbonElementPriority.MEDIUM);
		band1.addCommandButton(btnContract, RibbonElementPriority.MEDIUM);*/

		btnTransactionCustomer.addActionListener(e -> {
			buildPanel(myPanel,new CustomerTransactionPanel());
		});
		btnTransactionSupplier.addActionListener(e -> {
			buildPanel(myPanel,new TransactionPanel());
		});
		
		btnContract.addActionListener(e -> {
			buildPanel(myPanel, new ContractPanel());
		});
		btnCheck.addActionListener(e->{
			buildPanel(myPanel, new CheckCrudPanel());
		});
	}
	
	public static JCommandButton drawProjects(JPanel myPanel, JRibbonBand band1)
	{
		JCommandButton btnProject = new JCommandButton("Project", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_action_bookmark.png"));
		JCommandButton btnBlock = new JCommandButton("Block", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_action_bookmark.png"));
		JCommandButton btnFlat = new JCommandButton("Flat", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_action_bookmark.png"));

		band1.addCommandButton(btnProject, RibbonElementPriority.TOP);
		//band1.addCommandButton(btnBlock, RibbonElementPriority.MEDIUM);
		//band1.addCommandButton(btnFlat, RibbonElementPriority.MEDIUM);


		btnProject.addActionListener(e -> {
			buildPanel(myPanel,new ProjectElementsPanel());
		});
		
		btnBlock.addActionListener(e -> {
			buildPanel(myPanel,new BlockCrudPanel());
		});
		
		btnFlat.addActionListener(e -> {
			buildPanel(myPanel,new FlatCrudPanel());
		});
		
		return btnProject;
	}
	

	private static void buildPanel(JPanel myPanel,JpanelTemplate currentPanel)
	{
		myPanel.removeAll();
	
		currentPanel.lazyInitalize();
		myPanel.add(currentPanel);
		myPanel.revalidate();
		myPanel.repaint();
	}


	public static void drawMainMenu(JPanel myPanel, JRibbonBand band)
	{
		JCommandButton button1 = new JCommandButton("Statistics", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_app_kthememgr.png"));
		//JCommandButton button2 = new JCommandButton("Supplier", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_app_ksame.png"));
		//JCommandButton button3 = new JCommandButton("Company", MainFrame.getResizableIconFromResource("48px-Crystal_Clear_app_error.png"));

		band.addCommandButton(button1, RibbonElementPriority.TOP);
		//band.addCommandButton(button2, RibbonElementPriority.MEDIUM);
		//band.addCommandButton(button3, RibbonElementPriority.MEDIUM);

		button1.addActionListener(e -> {
			buildPanel(myPanel,new StatisticsPanel());
		});

		/*button2.addActionListener(e -> {
			buildPanel(myPanel,new SupplierCrudPanel());
		});

		button3.addActionListener(e -> {
			buildPanel(myPanel,new CompanyCrudPanel());
		});*/

		
	}
}
