/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.TableColumnModel;

import report.bean.ExpensesIconeReportBean;
import test.DataUtils;
import client.App;
import client.rmiclient.classes.crud.BeanTableModel;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.rmiclient.classes.crud.ReportFilterTableFrame;
import client.rmiclient.classes.crud.ReportFilterTableFrame.ControllerListener;
import client.rmiclient.classes.crud.tableReflection.Column;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import client.utils.table.NumberRenderer;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.action.bean.ReportTableModel;
import desktopadmin.action.bean.ReportTableModel.ExtraRowIndex;
import desktopadmin.model.accounting.EnumType.ExtraRowType;
import desktopadmin.utils.SearchBean;

/**
 *
 * @author User
 */
public class ProjectIncomeExpensesReportPanel extends JpanelTemplate
{

	
	private ReportFilterTableFrame filterTableFrame;



	private JLabel summary;
	

	public ProjectIncomeExpensesReportPanel(String title)
	{
		super();
	}

	public ProjectIncomeExpensesReportPanel( )
	{
		this("Report");
	}

	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("fill:p:grow","p,p,fill:p:grow"),this);
		builder.setDefaultDialogBorder();

		builder.appendSeparator("Customer Transactions");
		builder.append(summary);
		builder.append(filterTableFrame);

	}
	
	@Override
	public void initComponents( )
	{
		
		summary = new JLabel();
		filterTableFrame = new ReportFilterTableFrame();
		filterTableFrame.addControlPanel(new JPanel(), new ControllerListener()
		{
			
			@Override
			public void search(SearchBean searchBean)
			{
				fillCrudTable(searchBean);
				
			}
		});
		
		filterTableFrame.lazyInitalize();
		
		
		
	}




	protected void fillCrudTable(SearchBean searchBean )
	{

		ProgressBar.execute(new ProgressBarListener<ReportTableModel>()
		{

			@Override
			public ReportTableModel onBackground( ) throws Exception
			{
				SearchBean searchBean = new SearchBean();
				ExpensesIconeReportBean expensesIconeReportBean = new ExpensesIconeReportBean(DataUtils.getSelectedProjectId());
				searchBean.setHolder(expensesIconeReportBean);
				return App.getCrudService().getProjectExpensesIncome(searchBean);
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
		reportTableModel.addExtrass(Arrays.asList(new ExtraRowIndex(5,ExtraRowType.SUM),new ExtraRowIndex(6,ExtraRowType.SUM)));
		
		filterTableFrame.fillValues(fromReportTableModel(reportTableModel));
		
		TableColumnModel m = filterTableFrame.getTable().getColumnModel();
		m.getColumn(5).setCellRenderer(NumberRenderer.getCurrencyRenderer());
		m.getColumn(6).setCellRenderer(NumberRenderer.getCurrencyRenderer());
		
		Double balance = reportTableModel.getValueFromExtraRow(5)-reportTableModel.getValueFromExtraRow(6);
		
		summary.setText("Stock Balance : "+balance);
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
