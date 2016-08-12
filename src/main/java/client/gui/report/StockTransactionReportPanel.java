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

import report.bean.StockReportBean;
import test.DataUtils;
import client.App;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.rmiclient.classes.crud.ReportFilterTableFrame;
import client.rmiclient.classes.crud.ReportFilterTableFrame.ControllerListener;
import client.utils.ExCombo;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import client.utils.table.NumberRenderer;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.action.bean.ContractBean;
import desktopadmin.action.bean.Entry;
import desktopadmin.action.bean.ReportTableModel;
import desktopadmin.action.bean.ReportTableModel.ExtraRowIndex;
import desktopadmin.model.accounting.EnumType.ExtraRowType;
import desktopadmin.model.stock.Product;
import desktopadmin.utils.SearchBean;

/**
 *
 * @author User
 */
public class StockTransactionReportPanel extends JpanelTemplate
{

	private ReportFilterTableFrame filterTableFrame;


	private ExCombo<Entry> comboSupplier;

	private ExCombo<Product> comboProduct;


	public StockTransactionReportPanel(String title)
	{
		super();
	}

	public StockTransactionReportPanel( )
	{
		this("Report");
	}

	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("fill:p:grow","p,p,fill:p:grow"), this);
		builder.setDefaultDialogBorder();

		builder.appendSeparator("Customer Transactions");
		builder.append(getController());
		builder.append(filterTableFrame);

	}

	@Override
	public void initComponents( )
	{
		

		comboSupplier = new ExCombo<>();

		comboProduct = new ExCombo<>("All", DataUtils.getProducts());


		filterTableFrame = new ReportFilterTableFrame();
		filterTableFrame.addControlPanel(getController(), new ControllerListener()
		{
			
			@Override
			public void search(SearchBean searchBean)
			{
				fillCrudTable();
				
			}
		});
		filterTableFrame.init();
		
		fillData();

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

				comboSupplier.setValues("All", entries);
			}
		}, this);

	}

	private JPanel getController( )
	{
		JPanel panel = new JPanel();
		panel.add(new JLabel("Suppliers"));
		panel.add(comboSupplier);
		panel.add(new JLabel("Product"));
		panel.add(comboProduct);

		return panel;

	}

	protected void fillCrudTable( )
	{

		ProgressBar.execute(new ProgressBarListener<ReportTableModel>()
		{

			@Override
			public ReportTableModel onBackground( ) throws Exception
			{
				Long productId = comboProduct.getValue() == null ? -1L : comboProduct.getValue().getId();
				Long supplierId = comboSupplier.getValue() == null ? -1L : comboSupplier.getValue().getId();
				
				StockReportBean stockReportBean = new StockReportBean(productId, supplierId, DataUtils.getSelectedProjectId());
				
				return App.getCrudService().getStock(new SearchBean());
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

		if(reportTableModel.isEmpty())
			return;
		
		reportTableModel.addExtrass(Arrays.asList(new ExtraRowIndex(2, ExtraRowType.SUM),
				new ExtraRowIndex(3, ExtraRowType.SUM),
				new ExtraRowIndex(5, ExtraRowType.SUM)
				
		));

		filterTableFrame.fillValues(SupplierTransactionReportPanel.fromReportTableModel(reportTableModel));

		TableColumnModel m = filterTableFrame.getTable().getColumnModel();
		m.getColumn(4).setCellRenderer(NumberRenderer.getCurrencyRenderer());
		m.getColumn(5).setCellRenderer(NumberRenderer.getCurrencyRenderer());
	}

}
