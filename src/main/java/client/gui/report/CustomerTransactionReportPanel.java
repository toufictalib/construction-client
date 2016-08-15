/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.report;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.TableColumnModel;

import report.bean.CustomerReportBean;
import test.DataUtils;
import client.App;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.rmiclient.classes.crud.ReportFilterTableFrame;
import client.rmiclient.classes.crud.ReportFilterTableFrame.ControllerListener;
import client.utils.ExCombo;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import client.utils.table.NumberRenderer;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.action.bean.ContractBean;
import desktopadmin.action.bean.ContractEntry;
import desktopadmin.action.bean.Entry;
import desktopadmin.action.bean.ReportTableModel;
import desktopadmin.action.bean.ReportTableModel.ExtraRowIndex;
import desktopadmin.model.accounting.EnumType.ExtraRowType;
import desktopadmin.utils.SearchBean;

/**
 *
 * @author User
 */
public class CustomerTransactionReportPanel extends JpanelTemplate
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3945480819383996016L;


	private ReportFilterTableFrame filterTableFrame;


	private ExCombo<Entry> comboCustomer;

	private ExCombo<ContractEntry> comboContract;
	
	private Map<Object, List<ContractEntry>> contractEntryByCustomer;

	public CustomerTransactionReportPanel(String title)
	{
		super();
	}

	public CustomerTransactionReportPanel( )
	{
		this("Report");
	}

	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("fill:p:grow","p,p,fill:p:grow"),this);
		builder.setDefaultDialogBorder();

		builder.appendSeparator("Customer Transactions");
	//	builder.append(getController());
		builder.append(filterTableFrame);

	}
	
	@Override
	public void initComponents( )
	{
		
		
		comboContract = new ExCombo<>();
		comboCustomer = new ExCombo<>();
		comboCustomer.addItemListener(e->{
			if(comboCustomer.getValue()!=null)
			{
			if(contractEntryByCustomer.get(comboCustomer.getValue().getId())!=null){
				comboContract.setValues(contractEntryByCustomer.get(comboCustomer.getValue().getId()));
			}}
		});
		
		
		
		filterTableFrame = new ReportFilterTableFrame();
		filterTableFrame.addControlPanel(getController(),new ControllerListener()
		{
			
			@Override
			public void search(SearchBean searchBean)
			{
				if (validateSelection())
				{
					fillCrudTable(searchBean);
				}
				
			}
		});
		
		filterTableFrame.lazyInitalize();
		
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
				comboCustomer.setValues(true,response.getCustomers());
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

		return panel;

	}

	protected void fillCrudTable(final SearchBean searchBean )
	{

		ProgressBar.execute(new ProgressBarListener<ReportTableModel>()
		{

			@Override
			public ReportTableModel onBackground( ) throws Exception
			{
				CustomerReportBean customerReportBean = new CustomerReportBean(comboCustomer.getValue().getId(), comboContract.getValue().getId());
				searchBean.setHolder(customerReportBean);
				return App.getCrudService().getCustomerTransaction(searchBean);
			}

			@Override
			public void onDone(ReportTableModel response)
			{
				setData(response);

			}
		}, this);
	}


	public void setData(ReportTableModel reportTableModel)
	{
		int purchase = 2;
		int payment = 3;
		
		reportTableModel.addExtrass(Arrays.asList(
				new ExtraRowIndex(purchase,ExtraRowType.SUM),
				new ExtraRowIndex(payment,ExtraRowType.SUM)));
		
		filterTableFrame.fillValues(ProjectIncomeExpensesReportPanel.fromReportTableModel(reportTableModel));
		
		TableColumnModel m = filterTableFrame.getTable().getColumnModel();
		m.getColumn(purchase).setCellRenderer(NumberRenderer.getCurrencyRenderer());
		m.getColumn(payment).setCellRenderer(NumberRenderer.getCurrencyRenderer());
	}


	

}
