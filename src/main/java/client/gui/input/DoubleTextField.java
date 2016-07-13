package client.gui.input;

import javax.swing.JTextField;

public class DoubleTextField extends JTextField
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8512234769416723831L;

	public DoubleTextField(Long value)
	{
		super(value != null ? value+"" : "");
	}
	
	public DoubleTextField()
	{
		this(null);
	}


	public Double getValue()
	{
		return Double.parseDouble(getText());
	}
}