package client.gui.crudPanel;

import java.awt.Dimension;
import java.util.List;
import java.util.stream.Collectors;

import test.DataUtils;
import client.App;
import client.bean.CrudCustomer;
import client.rmiclient.classes.crud.BeanComplexElement;
import client.rmiclient.classes.crud.ExtendedCrudPanel;
import client.rmiclient.classes.crud.ModelHolder;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.model.person.Customer;

public class CustomerCrudPanel extends ExtendedCrudPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -897114854988642360L;

	private BeanComplexElement beanComplexElement;

	public CustomerCrudPanel( )
	{
		super("Customer");
	}

	public CustomerCrudPanel(String title)
	{
		super(title);
	}

	@Override
	protected void fillCrudTable( )
	{
		ProgressBar.execute(new ProgressBarListener<List<Customer>>()
		{

			@Override
			public List<Customer> onBackground( ) throws Exception
			{
				return App.getCrudService().list(Customer.class);
			}

			@Override
			public void onDone(List<Customer> response)
			{
				crudPanel.fillValues(new ModelHolder(response.stream().map(e -> CrudCustomer.fromModel(e)).collect(Collectors.toList()), CrudCustomer.class));

			}
		}, this);

	}

	@Override
	public void initComponents( )
	{
		// TODO Auto-generated method stub
		super.initComponents();
		beanComplexElement = new BeanComplexElement();
		crudPanel.setBeanComplexElement(beanComplexElement);
		beanComplexElement.addObjects("title", DataUtils.titles());
		
	}

	@Override
	protected void btnCancelAction( )
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void btnSaveAction( )
	{
		ProgressBar.execute(new ProgressBarListener<Void>()
		{

			@Override
			public Void onBackground( ) throws Exception
			{
				List<CrudCustomer> result = crudPanel.getResult(CrudCustomer.class);
				List<Customer> customers = result.stream().map(e -> e.toModel()).collect(Collectors.toList());
				App.getCrudService().saveOrUpdate(customers);

				return null;
			}

			@Override
			public void onDone(Void response)
			{

				MessageUtils.showInfoMessage(CustomerCrudPanel.this, "Data has been saved");
			}
		}, this);

	}

}
