package client.gui.crudPanel.subPanel;

import client.rmiclient.classes.crud.MyComponent;

public class AddressMyComponent extends MyComponent
{

	private AddressPanel addressPanel;

	public AddressMyComponent( )
	{
		super();
		this.addressPanel = new AddressPanel();
		this.component = addressPanel;
		addressPanel.lazyInitalize();
	}

	@Override
	public Object getValue( ) throws Exception
	{
		return addressPanel.getAddress();
	}

	public void setValue(Object value) throws Exception
	{

	};
}
