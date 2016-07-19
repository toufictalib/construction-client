/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.gui.report;

import java.util.ArrayList;
import java.util.List;

import client.App;
import client.rmiclient.classes.crud.BeanTableModel;
import client.rmiclient.classes.crud.ExtendedCrudPanel;
import client.rmiclient.classes.crud.ModelHolder;
import client.rmiclient.classes.crud.tableReflection.Column;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.action.bean.ReportTableModel;

/**
 *
 * @author User
 */
public class MyReportPanel extends ExtendedCrudPanel {

    private List data;

    public MyReportPanel(String title) {
        super(title);
    }

    public MyReportPanel() {
        this("Report");
    }

    @Override
    public void initComponents() {
        super.initComponents();
        crudPanel.hideAllButtons();
        crudPanel.showRefreshButton();
        hideButtons();

        crudPanel.allowUpdate(false);
    }

    @Override
    protected void fillCrudTable() {

    	ProgressBar.execute(new ProgressBarListener<ReportTableModel>()
		{

			@Override
			public ReportTableModel onBackground( ) throws Exception
			{
				return App.getCrudService().getCustomerTransaction(1l, 1l);
			}

			@Override
			public void onDone(ReportTableModel response)
			{
				setData(response);
				
			}
		},this);
    }

    public void setData(List data) {
        this.data = data;
        crudPanel.fillValues(new ModelHolder(getData(), data.isEmpty() ? Object.class : data.get(0).getClass()));
    }

    public void setData(ReportTableModel reportTableModel) {
        crudPanel.fillValues(fromReportTableModel(reportTableModel));
    }

    @SuppressWarnings("rawtypes")
	public static BeanTableModel fromReportTableModel(ReportTableModel reportTableModel)
    {
    	int counter = 0;
    	
    	List<Column> columns = new ArrayList<>();
    	for(String col:reportTableModel.cols)
    	{
    		Column column = new Column(col);
    		column.setType(reportTableModel.clazzes.get(counter++));
    		columns.add(column);
    	}
    	
    	return new BeanTableModel<>(columns, reportTableModel.rows);
    }
    
    public List getData() {
        if (data != null) {
            return data;
        }
        throw new UnsupportedOperationException("Please Extends this class to fill table data");
    }

    @Override
    protected void btnCancelAction() {
    }

    @Override
    protected void btnSaveAction() {

    }

}
