/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.rmiclient.classes.crud;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;

import client.gui.report.TableFooter;

/**
 *
 * @author User
 */
public class ReportFilterTableFrame extends FilterTableFrame implements Acceptable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4382501662729174873L;
	private TableFooter tableFooter;

	public ReportFilterTableFrame( ) throws HeadlessException
	{

		lazyInitalize();
	}

	@Override
	public void lazyInitalize( )
	{
		super.lazyInitalize();
	}

	public void setTableDimension(Dimension tableDimension)
	{
		reBuildPanel();
	}

	@Override
	public void init( )
	{
		super.init();
		//tableFooter = new TableFooter(table);
		//add(tableFooter.getPanel(), BorderLayout.CENTER);

	}

	@SuppressWarnings("rawtypes")
	public void fillValues(BeanTableModel beanTableModel)
	{

		super.fillValues(beanTableModel);

		//tableFooter.init(table);

	}


}
