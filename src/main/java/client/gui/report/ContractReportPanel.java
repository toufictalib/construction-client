/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.report;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import test.DataUtils;
import client.App;
import client.gui.button.ButtonFactory;
import client.gui.window.WindowUtils;
import client.rmiclient.classes.crud.BeanTableModel;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.rmiclient.classes.crud.tableReflection.Column;
import client.utils.DefaultFormBuilderUtils;
import client.utils.ExCombo;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.action.bean.ContractBean;
import desktopadmin.action.bean.ContractEntry;
import desktopadmin.action.bean.Entry;
import desktopadmin.action.bean.ReportTableModel;
import desktopadmin.model.sold.Contract;

/**
 *
 * @author User
 */
public class ContractReportPanel extends JpanelTemplate
{

	

	private List data;

	private ExCombo<Entry> comboCustomer;

	private ExCombo<ContractEntry> comboContract;
	
	private JButton btnSearch;
	
	private List<Contract> contracts;
	
	
	private Map<Object, List<ContractEntry>> contractEntryByCustomer;
	
	private JPanel bodyPanel;

	public ContractReportPanel(String title)
	{
		super();
	}

	public ContractReportPanel( )
	{
		this("Report");
	}

	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("fill:p:grow"),this);
		builder.setDefaultDialogBorder();

		builder.appendSeparator("Customer Transactions");
		builder.append(getController());
		builder.append(bodyPanel);

	}
	
	@Override
	public void initComponents( )
	{
		bodyPanel = new JPanel(new BorderLayout());
		
		comboContract = new ExCombo<>();
		comboCustomer = new ExCombo<>();
		comboCustomer.addItemListener(e->{
			if(contractEntryByCustomer.get(comboCustomer.getValue().getId())!=null){
				comboContract.setValues(contractEntryByCustomer.get(comboCustomer.getValue().getId()));
			}
		});
		
		btnSearch = ButtonFactory.createBtnSearch();
		btnSearch.addActionListener(e->{
			
			if (validateSelection())
			{
				fillCrudTable();
			}
		});
		
		fillData();

	}

	private boolean validateSelection( )
	{
		String message = "";
		if(comboCustomer.getValue()==null)
		{
			message+="Please Select Customer \\n";
		}
		
		if(comboContract.getValue()==null)
		{
			message+="Please Select Contract";
		}
		
		if(!message.isEmpty()){
			MessageUtils.showWarningMessage(this, message);
			return false;
		}
		
		return true;
		
	}

	private void fillData( )
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
				comboCustomer.setValues(response.getCustomers());
				contractEntryByCustomer = response.getContracts().stream().collect(Collectors.groupingBy(e->e.getCustomerId()));
			}
		}, this);
		
	}

	private JPanel getController( )
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Customers"));
		panel.add(comboCustomer);
		panel.add(new JLabel("Contract"));
		panel.add(comboContract);
		panel.add(btnSearch);

		return panel;

	}

	protected void fillCrudTable( )
	{

		if(contracts!=null)
		{
			
			fillBodyPanel();
			return;
		}
		
		
		
		ProgressBar.execute(new ProgressBarListener<List<Contract>>()
		{

			

			@Override
			public List<Contract> onBackground( ) throws Exception
			{
				return App.getCrudService().getCustomerContracts(DataUtils.getSelectedProjectId());
			}

			@Override
			public void onDone(List<Contract> response)
			{
				contracts = response;
				fillBodyPanel();

			}
		}, this);
	}



	private Contract  getSelectedProject()
	{
		for(Contract contract:contracts)
		{
			if(contract.getId().equals(comboContract.getValue().getId()))
			{
				return contract;
			}
			
		}
		return null;
	}
	
	private double getValue(Object o)
	{
		if(o!=null || !o.toString().isEmpty() )
		{
			String p = o.toString().replace("$", "");
			if(p.isEmpty())
				return 0;
			return Double.parseDouble(p);
		}
		return 0;
	}
	private void fillBodyPanel()
	{
		StringBuilder buffer = new StringBuilder();
		ProgressBar.execute(new ProgressBarListener<ReportTableModel>()
		{

			@Override
			public ReportTableModel onBackground( ) throws Exception
			{
				return App.getCrudService().getCustomerTransaction(comboCustomer.getValue().getId(), comboContract.getValue().getId());
			}

			@Override
			public void onDone(ReportTableModel response)
			{
				double totalPayment=0;
				double totalPurchase=0;
				
				buffer.append(getRow(response.cols));
				for(List o:response.rows)
				{
					buffer.append(getRow(o));
					
					totalPurchase +=getValue(o.get(2));
					totalPayment+=getValue(o.get(3));
				}
				
				buffer.append("total Payment : "+totalPayment+"\n");
				buffer.append("total Purchase: "+totalPurchase+"\n");
				
				Contract contract = getSelectedProject();
				DefaultFormBuilder builder = DefaultFormBuilderUtils.createRightDefaultFormBuilder("p,10dlu,fill:p:grow", null, false);
				builder.setDefaultDialogBorder();

				builder.appendSeparator("Contract");
				/*JPanel panel = new JPanel();
				panel.add(comboProjects);
				panel.add(btnStart);
				builder.append("projects", panel);*/

				builder.append("Description", getLabel(contract.getDescription()));
				builder.append("Block",  new JLabel(contract.getRealEstate().getBlock().getName()));
				builder.append("Real Estate",  new JLabel(contract.getRealEstate().getDescription()));
				builder.append("Price($)",  new JLabel(contract.getRealEstate().getPrice()+" $"));
				builder.append("Entilement Date",  new JLabel(contract.getEntilementDate().toString()));
				builder.append(new JTextArea(buffer.toString()),builder.getColumnCount());
				bodyPanel.removeAll();
				bodyPanel.add(builder.getPanel());
				bodyPanel.repaint();
				
				getOwner().pack();
				
			}
		}, this);
		
	
	}
	
	private String getRow(List list)
	{
		StringBuilder builder = new StringBuilder();
		
		
		for(int i=0;i<list.size();i++)
		{
			Object o= list.get(i);
			if(o!=null)
			{
				if(i==list.size()-1)
				{
					builder.append(o.toString()+"\n");
				}
				else
				{
					builder.append(o.toString()+"\t");
				}
				
					
			}
			
			else
			{
				builder.append("");
			}
		}
		return builder.toString();
	}
	
	private JLabel getLabel(String text)
	{
		Font font = null;
			font = new Font("Arial Narrow Bold", Font.BOLD, 15);
        JLabel happy = new JLabel(text);
      
        if(font!=null)
        happy.setFont(font.deriveFont(Font.BOLD, 48f));
        return happy;
	}
	@SuppressWarnings("rawtypes")
	public static BeanTableModel fromReportTableModel(ReportTableModel reportTableModel)
	{
		int counter = 0;

		List<Column> columns = new ArrayList<>();
		for (String col : reportTableModel.cols)
		{
			Column column = new Column(col);
			column.setType(reportTableModel.clazzes.get(counter++ ));
			columns.add(column);
		}

		return new BeanTableModel<>(columns, reportTableModel.rows);
	}

	public void showFrame(Window owner)
	{
		 JDialog frame = new JDialog(owner);
	        WindowUtils.installEscapeCloseOperation(frame);
	        frame.setTitle("dd");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setContentPane(this);
	        frame.pack();

	        frame.setMinimumSize(frame.getPreferredSize());
	        frame.setLocationRelativeTo(owner);
	        frame.setVisible(true);
	}
	

}
