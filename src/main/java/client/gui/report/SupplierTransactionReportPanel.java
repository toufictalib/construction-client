/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.report;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import report.bean.SupplierReportBean;
import test.DataUtils;
import client.App;
import client.rmiclient.classes.crud.BeanTableModel;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.rmiclient.classes.crud.ReportFilterTableFrame;
import client.rmiclient.classes.crud.ReportFilterTableFrame.ControllerListener;
import client.rmiclient.classes.crud.tableReflection.Column;
import client.utils.ExCombo;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.action.bean.ContractBean;
import desktopadmin.action.bean.Entry;
import desktopadmin.action.bean.ReportTableModel;
import desktopadmin.utils.SearchBean;

/**
 *
 * @author User
 */
public class SupplierTransactionReportPanel extends JpanelTemplate
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4477122575022068775L;


	private ReportFilterTableFrame filterTableFrame;


	private ExCombo<Entry> comboCustomer;

	public SupplierTransactionReportPanel(String title)
	{
		super();
	}

	public SupplierTransactionReportPanel( )
	{
		this("Report");
	}

	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("fill:p:grow","p,p,fill:p:grow"),this);
		builder.setDefaultDialogBorder();

		builder.appendSeparator("Customer Transactions");
		///builder.append(getController());
		builder.append(filterTableFrame);

	}
	
	@Override
	public void initComponents( )
	{
		
		comboCustomer = new ExCombo<>();
		filterTableFrame = new ReportFilterTableFrame();
		filterTableFrame.addControlPanel(getController(), new ControllerListener()
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
				return App.getCrudService().getSupplierContractBean(DataUtils.getSelectedProject().getId());
			}

			@Override
			public void onDone(ContractBean response)
			{
				List<Entry> entries = new ArrayList<>();
				entries.addAll(response.getCompanies());
				entries.addAll(response.getSuppliers());
				
				comboCustomer.setValues(entries);
			}
		}, this);
		
	}

	private JPanel getController( )
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Suppliers"));
		panel.add(comboCustomer);

		return panel;

	}

	protected void fillCrudTable(SearchBean searchBean )
	{

		ProgressBar.execute(new ProgressBarListener<ReportTableModel>()
		{

			@Override
			public ReportTableModel onBackground( ) throws Exception
			{
				SupplierReportBean supplierReportBean = new SupplierReportBean(comboCustomer.getValue().getId(), DataUtils.getSelectedProjectId());
				searchBean.setHolder(supplierReportBean);
				return App.getCrudService().getSupplierTransaction(searchBean);
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
