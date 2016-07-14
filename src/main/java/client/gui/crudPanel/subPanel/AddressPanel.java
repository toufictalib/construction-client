package client.gui.crudPanel.subPanel;

import javax.swing.JTextArea;

import client.rmiclient.classes.crud.JpanelTemplate;
import client.utils.ExCombo;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.model.building.Address;
import desktopadmin.model.building.Address.Caza;
import desktopadmin.model.building.Address.County;

public class AddressPanel extends JpanelTemplate
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2154208015665821974L;

	private Address address;

	private ExCombo<Caza> comboCaza;

	private ExCombo<County> comboCounty;

	private JTextArea txtAreaDescription;
	

	public AddressPanel( )
	{
		// TODO Auto-generated constructor stub
	}

	public AddressPanel(Address address)
	{
		this.address = address;
	}

	public Address getAddress()
	{
		Address address = new Address();
		address.setCaza(comboCaza.getValue());
		address.setCounty(comboCounty.getValue());
		address.setDescription(txtAreaDescription.getText().trim());
		return address;
	}
	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("p,10dlu,fill:p:grow"),this);
		builder.setDefaultDialogBorder();
		
		
		builder.append("Description",txtAreaDescription);
		builder.append("Caza",comboCaza);
		builder.append("County",comboCounty);
		
		
	}

	@Override
	public void initComponents( )
	{
		txtAreaDescription = new JTextArea(5, 5);

		comboCaza = new ExCombo<Address.Caza>(Caza.values());

		comboCounty = new ExCombo<Address.County>(County.values());

		// TODO Auto-generated method stub

	}
	
	public void clear()
	{
		
	}
	

}
