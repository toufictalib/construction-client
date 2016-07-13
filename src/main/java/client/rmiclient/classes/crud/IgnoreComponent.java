package client.rmiclient.classes.crud;

import javax.swing.JTextField;

import client.rmiclient.classes.crud.tableReflection.Column;

/**
 *
 * @author User
 */
public class IgnoreComponent extends MyComponent
{

	JTextField field;

	private Object o;

	public IgnoreComponent( )
	{
		super();

		field = new JTextField();
		this.component = field;

	}

	@Override
	public Object getValue( ) throws Exception
	{
		return o;
	}

	public void setValue(Object value) throws Exception
	{
		if (value != null)
		{
			o = value;
			field.setText(value.toString());
		}
	}

	public Column getColumn( )
	{
		return column;
	}

}
