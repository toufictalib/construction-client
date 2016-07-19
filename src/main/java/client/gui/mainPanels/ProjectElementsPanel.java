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
import test.TransactionPanel;
import client.gui.crudPanel.BlockCrudPanel;
import client.gui.crudPanel.FlatCrudPanel;
import client.gui.mainPanels.ProjectChooserPanel.ProjectButtonsActionListener;
import client.gui.normalPanel.ContractPanel;
import client.gui.report.MyReportPanel;
import client.gui.window.WindowUtils;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.utils.ComponentUtils;
import client.utils.DefaultFormBuilderUtils;

import com.jgoodies.forms.builder.DefaultFormBuilder;
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
		JButton btnAddSupplierTransaction = new JButton("Add Supplier Transaction");
		JButton btnAddCustomerTransaction = new JButton("Add Customer Transaction");
		JButton btnAddContract = new JButton("Add Contract");

		ActionListener actionListener = e -> {
			if (e.getSource() == btnAddCustomerTransaction)
			{
				open(new CustomerTransactionPanel(), "Customer Transaction");

			}
			else
				if (e.getSource() == btnAddSupplierTransaction)
				{
					open(new TransactionPanel(), "Supplier Transaction");
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

	private void open(JpanelTemplate panelTemplate, String title)
	{
		panelTemplate.lazyInitalize();
		WindowUtils.createDialog(getOwner(), title, panelTemplate);
	}

	private JPanel getProjectDetailsPanel( )
	{

		// init
		JButton btnAddBlock = new JButton("Add Block");
		JButton btnAddFlat = new JButton("Add Flat");
		JButton btnAddStore = new JButton("Add Store");
		JButton btnAddWarehouse = new JButton("Add WareHouse");

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
		JButton btnShowCustomerTransaction = new JButton("Show Customer Transaction");

		ActionListener actionListener = e -> {
			if (e.getSource() == btnShowCustomerTransaction)
			{

				open(new MyReportPanel(), "Report");
			}
		};

		btnShowCustomerTransaction.addActionListener(actionListener);

		// initl layout
		DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("fill:p:grow", null, false);
		builder.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Project Details"));

		builder.append(btnShowCustomerTransaction);

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

			DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("fill:p:grow", null, false);

			//builder.append(lblSelectedProject);
			builder.append(getProjectDetailsPanel());
			builder.append(getFinancePanel());
			builder.append(getReportDetails());

			rightPanel.add(builder.getPanel());
			rightPanel.revalidate();
			rightPanel.repaint();
		}

	}
}
