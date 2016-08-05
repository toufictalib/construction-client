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

	private JPanel getFinancePanel( )
	{

		// init
		JButton btnAddSupplierTransaction = createMenuButton("Add Supplier Transaction");
		JButton btnAddCustomerTransaction = createMenuButton("Add Customer Transaction");
		JButton btnAddContract = createMenuButton("Add Contract");

		ActionListener actionListener = e -> {
			if (e.getSource() == btnAddCustomerTransaction)
			{
				open(new CustomerTransactionPanel(), "Customer Transaction");

			}
			else
				if (e.getSource() == btnAddSupplierTransaction)
				{
					open(new SupplierTransactionPanel(), "Supplier Transaction");
				}
				else
					if (e.getSource() == btnAddContract)
					{
						open(new ContractPanel(), "Contract");
					}
		};

		btnAddSupplierTransaction.addActionListener(actionListener);
		btnAddCustomerTransaction.addActionListener(actionListener);
		btnAddContract.addActionListener(actionListener);

		// initl layout
		DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("fill:p:grow", null, false);
		builder.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Finance"));

		builder.append(btnAddCustomerTransaction);
		builder.append(btnAddSupplierTransaction);
		builder.append(btnAddContract);

		return builder.getPanel();

	}

	private JButton createMenuButton(String text)
	{
		JButton btn = new JButton(text);
		btn.setPreferredSize(new Dimension(200,btn.getPreferredSize().height));return btn;
	}
	private void open(JpanelTemplate panelTemplate, String title)
	{
		panelTemplate.lazyInitalize();
		WindowUtils.createDialog(getOwner(),title, panelTemplate);
	}
	
	private void openReport(JpanelTemplate panelTemplate, String title)
	{
		panelTemplate.lazyInitalize();
		WindowUtils.createFrame(title, panelTemplate);
	}

	private JPanel getProjectDetailsPanel( )
	{

		// init
		JButton btnAddBlock = createMenuButton("Add Block");
		JButton btnAddFlat = createMenuButton("Add Flat");
		//btnAddBlock.setPreferredSize(new Dimension(250,btnAddBlock.getPreferredSize().height));
		JButton btnAddStore = createMenuButton("Add Store");
		JButton btnAddWarehouse = createMenuButton("Add WareHouse");

		ActionListener actionListener = e -> {
			if (e.getSource() == btnAddBlock)
			{

				open(new BlockCrudPanel(), "Block");
			}
			else
				if (e.getSource() == btnAddFlat)
				{
					open(new FlatCrudPanel(), "Flat");
				}
				else
					if (e.getSource() == btnAddStore)
					{

					}

					else
						if (e.getSource() == btnAddWarehouse)
						{

						}
		};

		btnAddBlock.addActionListener(actionListener);
		btnAddFlat.addActionListener(actionListener);
		btnAddStore.addActionListener(actionListener);
		btnAddWarehouse.addActionListener(actionListener);

		// initl layout
		DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("fill:p:grow", null, false);
		builder.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Project Details"));

		builder.append(btnAddBlock);
		builder.append(btnAddFlat);
		builder.append(btnAddStore);
		builder.append(btnAddWarehouse);

		return builder.getPanel();

	}
	
	private JPanel getReportDetails( )
	{

		// init
		JButton btnShowCustomerTransaction = createMenuButton("Show Customer Transaction");
		JButton btnShowSupplierTransaction = createMenuButton("Show Supplier Transaction");
		JButton btnShowContract = createMenuButton("Show Contract Information");
		JButton btnShowIncomeAndExpenses = createMenuButton("Show Income & Expenses");

		ActionListener actionListener = e -> {
			if (e.getSource() == btnShowCustomerTransaction)
			{

				openReport(new CustomerTransactionReportPanel(), "Customer Report");
			}
			
			else if(e.getSource()==btnShowSupplierTransaction)
			{
				openReport(new SupplierTransactionReportPanel(), "Supplier Report");
			}
			else if(e.getSource()==btnShowContract)
			{
				openReport(new ContractReportPanel(), "Contract Report");
			}
			else if(e.getSource()==btnShowIncomeAndExpenses)
			{
				openReport(new ProjectIncomeExpensesReportPanel(),"Income and Expenses Report");
			}
		};

		btnShowCustomerTransaction.addActionListener(actionListener);
		btnShowSupplierTransaction.addActionListener(actionListener);
		btnShowContract.addActionListener(actionListener);
		btnShowIncomeAndExpenses.addActionListener(actionListener);

		// initl layout
		DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("fill:p:grow", null, false);
		builder.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Reports"));

		builder.append(btnShowCustomerTransaction);
		builder.append(btnShowSupplierTransaction);
		builder.append(btnShowContract);
		builder.append(btnShowIncomeAndExpenses);

		return builder.getPanel();

	}
	
	
	private JPanel getStockSection( )
	{

		// init
		JButton btnShowStocks = createMenuButton("Show Stocks");

		ActionListener actionListener = e -> {
			if (e.getSource() == btnShowStocks)
			{

				openReport(new StockTransactionReportPanel(), "Report");
			}
		};

		btnShowStocks.addActionListener(actionListener);

		// initl layout
		DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("fill:p:grow", null, false);
		builder.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Stocks"));

		builder.append(btnShowStocks);

		return builder.getPanel();

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

			FormLayout formLayout = new FormLayout("fill:p:grow,10dlu,fill:p:grow", "p,p");
			DefaultFormBuilder builder = new DefaultFormBuilder(formLayout);

			//builder.append(lblSelectedProject);
			CellConstraints cc = new CellConstraints();
			
			builder.add(getProjectDetailsPanel(),  cc.xy  (1, 1, "left, top"));
			builder.add(getFinancePanel(),  cc.xy  (3, 1, "left, top"));
			builder.add(getReportDetails(),  cc.xy  (1, 2, "left, top"));
			builder.add(getStockSection(),  cc.xy  (3, 2, "left, top"));
			
			/*builder.append(getProjectDetailsPanel());
			builder.append(getFinancePanel());
			builder.append(getReportDetails());
			builder.append(getStockSection());*/

			rightPanel.add(builder.getPanel());
			rightPanel.revalidate();
			rightPanel.repaint();
		}

	}
}
