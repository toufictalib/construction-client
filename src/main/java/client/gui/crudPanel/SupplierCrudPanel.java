package client.gui.crudPanel;

import java.util.List;
import java.util.stream.Collectors;

import client.App;
import client.bean.CrudSupplier;
import client.rmiclient.classes.crud.ModelHolder;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.model.person.Supplier;

public class SupplierCrudPanel extends CustomerCrudPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8475866105953294820L;

	public SupplierCrudPanel( )
	{
		super("Supplier");
	}

	@Override
	protected void fillCrudTable( )
	{
		ProgressBar.execute(new ProgressBarListener<List<Supplier>>()
				{

					@Override
					public List<Supplier> onBackground( ) throws Exception
					{
						return App.getCrudService().list(Supplier.class);
					}

					@Override
					public void onDone(List<Supplier> response)
					{
						crudPanel.fillValues(new ModelHolder(response.stream()
								.map(e->CrudSupplier.fromModel(e)).collect(Collectors.toList()), CrudSupplier.class));
						
					}
				}, this);

	}
	
	@Override
	protected void btnSaveAction( )
	{
		ProgressBar.execute(new ProgressBarListener<Void>()
				{

					@Override
					public Void onBackground( ) throws Exception
					{
						List<CrudSupplier> result = crudPanel.getResult(CrudSupplier.class);
						List<Supplier> customers = result.stream().map(e -> e.toModel()).collect(Collectors.toList());
						App.getCrudService().saveOrUpdate(customers);

						return null;
					}

					@Override
					public void onDone(Void response)
					{

						MessageUtils.showInfoMessage(SupplierCrudPanel.this, "Data has been saved");
					}
				}, this);
	}
	
}
