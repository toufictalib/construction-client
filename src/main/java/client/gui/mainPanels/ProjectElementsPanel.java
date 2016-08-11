package client.gui.mainPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import test.DataUtils;
import test.StockTransactionPanel;
import test.SupplierPaymentTransactionPanel;
import test.SupplierTransactionPanel;
import client.gui.crudPanel.BlockCrudPanel;
import client.gui.crudPanel.FlatCrudPanel;
import client.gui.mainPanels.ProjectChooserPanel.ProjectButtonsActionListener;
import client.gui.normalPanel.ContractPanel;
import client.gui.report.ContractReportPanel;
import client.gui.report.CustomerTransactionReportPanel;
import client.gui.report.ProjectIncomeExpensesReportPanel;
import client.gui.report.StockTransactionReportPanel;
import client.gui.report.SupplierTransactionReportPanel;
import client.gui.window.WindowUtils;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.utils.ComponentUtils;
import client.utils.DefaultFormBuilderUtils;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.model.building.Project;

public class ProjectElementsPanel extends JpanelTemplate implements ProjectButtonsActionListener
{

	private JLabel lblSelectedProject;

	

	public ProjectElementsPanel( )
	{
		lazyInitalize();
	}

	@Override
	public void lazyInitalize( )
	{

		super.lazyInitalize();
	}

	@Override
	public void init( )
	{
		/*
		 * DefaultFormBuilder builder =
		 * DefaultFormBuilderUtils.createRightDefaultFormBuilder
		 * ("p,15dlu,fill:p:grow", this, false);
		 * builder.append(projectChooserPanel); CellConstraints cc = new
		 * CellConstraints(); builder.add(rightPanel), cc.xy(2, 1,
		 * "center, top"));
		 */

		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("p,10dlu,p", "fill:p:grow"));
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEADING));
		panel.add(projectChooserPanel);
		panel.add(rightPanel);

		builder.append(projectChooserPanel);
		builder.append(rightPanel);

		DefaultFormBuilder mainBuilder = new DefaultFormBuilder(new FormLayout("fill:p:grow"), this);
		mainBuilder.append(lblSelectedProject);
		mainBuilder.append(builder.getPanel());
		// this.add(panel);

	}

	@Override
	public void initComponents( )
	{
		projectChooserPanel = new ProjectChooserPanel(this);
		projectChooserPanel.lazyInitalize();
		projectChooserPanel.setPreferredSize(new Dimension(300, 450));

		lblSelectedProject = new JLabel("--None--");
		lblSelectedProject.setHorizontalAlignment(SwingConstants.CENTER);
		ComponentUtils.addTitleBorder(lblSelectedProject, "Selected Project");

		rightPanel = new JPanel();

	}

	private JPanel getSupplierFinance( )
	{

		ActionListener actionListener = e -> {
			if (FINACNE_SUPPLIER_PURCHASE_INVOICE.equals(e.getActionCommand()))
			{
				open(new SupplierTransactionPanel(), "Supplier Purchase Transaction");

			}
			else
				if (FINACNE_SUPPLIER_INVOICE_PAYMENT.equals(e.getActionCommand()))
				{
					open(new SupplierPaymentTransactionPanel(), "Supplier Payment Transaction");
				}
				else
					if (FINACNE_SUPPLIER_RECEIVE_STUFFS.equals(e.getActionCommand()))
					{
						open(new StockTransactionPanel(), "Receiving Stock");
					}
		};

		return createMenu("Supplier Finance", actionListener, FINACNE_SUPPLIER_PURCHASE_INVOICE, FINACNE_SUPPLIER_INVOICE_PAYMENT, FINACNE_SUPPLIER_RECEIVE_STUFFS);

	}
	
	private JPanel getCustomerFinance( )
	{

		ActionListener actionListener = e -> {
			if (FINACNE_CUSTOMER_ADD_CONTRACT.equals(e.getActionCommand()))
			{
				open(new ContractPanel(), "Create Contract");

			}
			else
				if (FINACNE_CUSTOMER_PAY_RECEIPT.equals(e.getActionCommand()))
				{
					open(new CustomerTransactionPanel(), "Pay Receipt");
				}
				else if(FINACNE_CUSTOMER_CANCEL_CONTRACT.equals(e.getActionCommand()))
				{
					
				}
		};

		return createMenu("Customer Finance", actionListener, 
				FINACNE_CUSTOMER_ADD_CONTRACT, 
				FINACNE_CUSTOMER_PAY_RECEIPT
				/*FINACNE_CUSTOMER_CANCEL_CONTRACT*/);

	}

	private JPanel getProjectDetailsPanel( )
	{

		ActionListener actionListener = e -> {
			if (e.getActionCommand().equals(PROJECT_ADD_BLOCK))
			{

				open(new BlockCrudPanel(), "Block");
			}
			else
				if (e.getActionCommand().equals(PROJECT_ADD_FLAT))
				{
					open(new FlatCrudPanel(), "Flat");
				}
				else
					if (e.getActionCommand().equals(PROJECT_ADD_STORE))
					{

					}

					else
						if (e.getActionCommand().equals(PROJECT_ADD_WAREHOUSE))
						{

						}
		};

		return createMenu("Project Details", actionListener, PROJECT_ADD_BLOCK, PROJECT_ADD_FLAT, PROJECT_ADD_STORE, PROJECT_ADD_WAREHOUSE);

	}

	private JPanel getReportDetails( )
	{

		ActionListener actionListener = e -> {
			if (e.getActionCommand().equals(REPORT_Show_Customer_Transaction))
			{

				openReport(new CustomerTransactionReportPanel(), "Customer Report");
			}

			else
				if (e.getActionCommand().equals(REPORT_Show_Supplier_Transaction))
				{
					openReport(new SupplierTransactionReportPanel(), "Supplier Report");
				}
				else
					if (e.getActionCommand().equals(REPORT_Show_Contract_Information))
					{
						openReport(new ContractReportPanel(), "Contract Report");
					}
					else
						if (e.getActionCommand().equals(REPORT_Show_Income_Expenses))
						{
							openReport(new ProjectIncomeExpensesReportPanel(), "Income and Expenses Report");
						}
		};

		return createMenu("Reports", actionListener, REPORT_Show_Customer_Transaction, REPORT_Show_Supplier_Transaction, REPORT_Show_Contract_Information, REPORT_Show_Income_Expenses);

	}

	private JPanel getStockSection( )
	{

		ActionListener actionListener = e -> {
			if (e.getActionCommand().equals(STOCK_SHOW_STOCK))
			{

				openReport(new StockTransactionReportPanel(), "Stock Movement");
			}
		};

		return createMenu("Stocks", actionListener, STOCK_SHOW_STOCK);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8077335089578246722L;

	private ProjectChooserPanel projectChooserPanel;

	private JPanel rightPanel;

	@Override
	public void btnApplyAction(Project project)
	{
		rightPanel.removeAll();

		if (project != null)
		{
			lblSelectedProject.setText("<html>" + "<b>" + project.getName() + "</b>" + "</html>");

			DataUtils.setSelectedProject(project);

			FormLayout formLayout = new FormLayout("fill:p:grow,10dlu,fill:p:grow", "p,p,p");
			DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);

			// builder.append(lblSelectedProject);
			CellConstraints cc = new CellConstraints();

			builder.add(getProjectDetailsPanel(), cc.xy(1, 1, "left, top"));
			builder.add(getSupplierFinance(), cc.xy(3, 1, "left, top"));
			builder.add(getCustomerFinance(), cc.xy(3, 2, "left, top"));
			builder.add(getReportDetails(), cc.xy(1, 2, "left, top"));
			builder.add(getStockSection(), cc.xy(3, 3, "left, top"));

			/*
			 * builder.append(getProjectDetailsPanel());
			 * builder.append(getFinancePanel());
			 * builder.append(getReportDetails());
			 * builder.append(getStockSection());
			 */

			rightPanel.add(builder.getPanel());
			rightPanel.revalidate();
			rightPanel.repaint();
		}

	}

	private JPanel createMenu(String menuTitle, ActionListener actionListener, String... menus)
	{

		// initl layout
		DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("fill:p:grow", null, false);
		builder.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), menuTitle));

		for (String menu : menus)
		{
			JButton btnAddSupplierTransaction = createMenuButton(menu);
			btnAddSupplierTransaction.addActionListener(actionListener);

			builder.append(btnAddSupplierTransaction);
		}

		return builder.getPanel();

	}

	private JButton createMenuButton(String text)
	{
		JButton btn = new JButton(text);
		btn.setPreferredSize(new Dimension(200, btn.getPreferredSize().height));
		return btn;
	}

	private void open(JpanelTemplate panelTemplate, String title)
	{
		panelTemplate.lazyInitalize();
		WindowUtils.createDialog(getOwner(), title, panelTemplate);
	}

	private void openReport(JpanelTemplate panelTemplate, String title)
	{
		panelTemplate.lazyInitalize();
		WindowUtils.createFrame(title, panelTemplate);
	}
	
	
	//menus
	private static final String FINACNE_SUPPLIER_PURCHASE_INVOICE = "Purchase Invoice";
	private static final String FINACNE_SUPPLIER_INVOICE_PAYMENT = "Supplier Payment";
	private static final String FINACNE_SUPPLIER_RECEIVE_STUFFS = "Receive Products";
	

	private static final String FINACNE_CUSTOMER_PAY_RECEIPT= "Pay Receipt";
	private static final String FINACNE_CUSTOMER_ADD_CONTRACT= "Add Contract";
	private static final String FINACNE_CUSTOMER_CANCEL_CONTRACT= "Cancel Contract";
	
	private final static String PROJECT_ADD_BLOCK = "Add Block";
	private final static String PROJECT_ADD_FLAT = "Add Flat";
	private final static String PROJECT_ADD_STORE = "Add Store";
	private final static String PROJECT_ADD_WAREHOUSE = "Add WareHouse";

	public final static String REPORT_Show_Customer_Transaction = "Show Customer Transaction";
	public final static String REPORT_Show_Supplier_Transaction = "Show Supplier Transaction";
	public final static String REPORT_Show_Contract_Information = "Show Contract Information";
	public final static String REPORT_Show_Income_Expenses = "Show Income & Expenses";

	public final static String STOCK_SHOW_STOCK = "Show Stocks";
}
