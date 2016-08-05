/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;

import test.DataUtils;
import client.App;
import client.gui.button.ButtonFactory;
import client.rmiclient.classes.crud.BeanTableModel;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.rmiclient.classes.crud.ReportFilterTableFrame;
import client.rmiclient.classes.crud.tableReflection.Column;
import client.utils.ExCombo;
import client.utils.MessageFactory;
import client.utils.MessageResolver;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.action.bean.ContractBean;
import desktopadmin.action.bean.ContractEntry;
import desktopadmin.action.bean.Entry;
import desktopadmin.action.bean.ReportTableModel;

/**
 *
 * @author User
 */
public class CustomerTransactionReportPanel extends JpanelTemplate
{

	
	private ReportFilterTableFrame filterTableFrame;

	private List data;

	private ExCombo<Entry> comboCustomer;

	private ExCombo<ContractEntry> comboContract;
	
	private JButton btnSearch;
	
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
		builder.append(getController());
		builder.append(filterTableFrame);

	}
	
	@Override
	public void initComponents( )
	{
		filterTableFrame = new ReportFilterTableFrame();
		
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
				setData(response);

			}
		}, this);
	}

	public void setData(List data)
	{
		this.data = data;
	}

	public void setData(ReportTableModel reportTableModel)
	{
		filterTableFrame.fillValues(fromReportTableModel(reportTableModel));
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

	

}
