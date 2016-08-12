package client.gui.table.utils;

import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXDatePicker;

import test.DataUtils;
import client.gui.input.IntergerTextField;
import client.utils.ComponentUtils;
import desktopadmin.utils.DateUtil;
import desktopadmin.utils.SearchBean;

public class SearchPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5251638566168674323L;

	private JXDatePicker datePickerFrom;

	private JXDatePicker datePickerTo;

	private IntergerTextField txtStartCount;

	private IntergerTextField txtEndCount;

	public static SearchPanel create( )
	{
		return new SearchPanel();
	}
	
	public static SearchPanel createDefault()
	{
		return new SearchPanel().addDatePickerFrom().addDatePickerTo().addStartCount().addEndCount();
	}

	public SearchPanel( )
	{
		super(new FlowLayout(FlowLayout.LEADING));
	}

	public SearchPanel addDatePickerFrom( )
	{
		datePickerFrom = ComponentUtils.createDatePicker();
		add(new JLabel("From Date :"));
		add(datePickerFrom);

		return this;
	}

	public SearchPanel addDatePickerTo( )
	{
		datePickerTo = ComponentUtils.createDatePicker();
		add(new JLabel("To Date :"));
		add(datePickerTo);

		return this;
	}

	public SearchPanel addStartCount( )
	{
		txtStartCount = new IntergerTextField(DataUtils.START_ROWS);
		add(new JLabel("Start Count:"));
		add(txtStartCount);

		return this;
	}

	public SearchPanel addEndCount( )
	{
		txtEndCount = new IntergerTextField(DataUtils.MAX_ROWS);
		add(new JLabel("Max Lines :"));
		add(txtEndCount);

		return this;
	}
	
	
	public Date getFromDate()
	{
		if(datePickerFrom.getDate()==null)
			return null;
		return datePickerFrom.getDate();
	}
	
	public Date getEndDate()
	{
		if(datePickerTo.getDate()==null)
			return null;
		return datePickerTo.getDate();
	}
	
	public int getStartCount()
	{
		return txtStartCount.getValue()==null ? DataUtils.START_ROWS : txtStartCount.getValue();
	}
	
	public int getEndCount()
	{
		return datePickerFrom.getDate()==null ? DataUtils.MAX_ROWS : txtEndCount.getValue();
	}
	
	
	public SearchBean toSearchBean()
	{
		return SearchBean.edit()
		.setFromDate(getFromDate()==null ? "-1" : DateUtil.formatShortSqlDate(getFromDate()))
		.setEndDate(getEndDate()==null ? "-1" :DateUtil.formatShortSqlDate(getEndDate()))
		.setStartCount(getStartCount())
		.setEndCount(getEndCount());
	}
	

}
