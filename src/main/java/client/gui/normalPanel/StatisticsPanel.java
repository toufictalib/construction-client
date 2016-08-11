package client.gui.normalPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import test.DataUtils;
import test.TransactionPanel;
import client.gui.mainPanels.CustomerTransactionPanel;
import client.gui.mainPanels.ProjectChooserPanel;
import client.gui.mainPanels.ProjectChooserPanel.ProjectButtonsActionListener;
import client.gui.window.WindowUtils;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.utils.DefaultFormBuilderUtils;

import com.jgoodies.forms.builder.DefaultFormBuilder;

import desktopadmin.model.building.Project;

public class StatisticsPanel extends JpanelTemplate implements ProjectButtonsActionListener
{

	private JLabel lblSelectedProject;
	
	public StatisticsPanel( )
	{
		lazyInitalize();
	}

	@Override
	public void init( )
	{
		/*DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("p,15dlu,fill:p:grow", this, false);
		builder.append(projectChooserPanel);
		CellConstraints cc = new CellConstraints();
		builder.add(rightPanel), cc.xy(2, 1, "center, top"));*/
		
		JPanel panel = new JPanel();
		
		panel.add(projectChooserPanel);
		panel.add(rightPanel);
		
		this.add(panel);
	
	}

	@Override
	public void initComponents( )
	{
		projectChooserPanel = new ProjectChooserPanel(this);
		projectChooserPanel.lazyInitalize();
		projectChooserPanel.setPreferredSize(new Dimension(300,450));

		lblSelectedProject = new JLabel();
		
		rightPanel = new JPanel();
		
		DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("fill:p:grow", null, false);
		
		builder.append(lblSelectedProject);
		builder.append(getProjectDetailsPanel());
		builder.append(getFinancePanel());
		
		rightPanel.add(builder.getPanel());
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
				CustomerTransactionPanel customerTransactionPanel = new CustomerTransactionPanel();
				customerTransactionPanel.lazyInitalize();
				WindowUtils.createDialog(getOwner(), "Customer Transaction", customerTransactionPanel);
				
			}
			else
				if (e.getSource() == btnAddSupplierTransaction)
				{
					TransactionPanel supplierTransactionPanel = new TransactionPanel();
					supplierTransactionPanel.lazyInitalize();
					WindowUtils.createDialog(getOwner(), "Supplier Transaction", supplierTransactionPanel);
				}
				else if(e.getSource()==btnAddContract)
				{
					ContractPanel contractPanel = new ContractPanel();
					contractPanel.lazyInitalize();
					WindowUtils.createDialog(getOwner(), "Contract", contractPanel);
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

			}
			else
				if (e.getSource() == btnAddFlat)
				{
					
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 8077335089578246722L;

	private ProjectChooserPanel projectChooserPanel;

	private JPanel rightPanel;

	@Override
	public void btnApplyAction(Project project)
	{
		lblSelectedProject.setText("<html>"
				+ "<b>"
				+ project.getName()
				+ "</b>"
				+ "</html>");
		
		DataUtils.setSelectedProject(project);
		
	}
}
