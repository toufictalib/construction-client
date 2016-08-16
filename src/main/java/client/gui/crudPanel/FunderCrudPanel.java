package client.gui.crudPanel;

import java.util.List;
import java.util.stream.Collectors;

import client.App;
import client.bean.CrudFunder;
import client.bean.CrudSupplier;
import client.rmiclient.classes.crud.ModelHolder;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.model.person.Funder;
import desktopadmin.model.person.Supplier;

public class FunderCrudPanel extends CustomerCrudPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8475866105953294820L;

	public FunderCrudPanel( )
	{
		super("Funder");
	}

	@Override
	protected void fillCrudTable( )
	{
		ProgressBar.execute(new ProgressBarListener<List<Funder>>()
				{

					@Override
					public List<Funder> onBackground( ) throws Exception
					{
						return App.getCrudService().list(Funder.class);
					}

					@Override
					public void onDone(List<Funder> response)
					{
						crudPanel.fillValues(new ModelHolder(response.stream()
								.map(e->CrudFunder.fromModel(e)).collect(Collectors.toList()), CrudSupplier.class));
						
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
						List<CrudFunder> result = crudPanel.getResult(CrudFunder.class);
						List<Funder> customers = result.stream().map(e -> e.toModel()).collect(Collectors.toList());
						App.getCrudService().saveOrUpdate(customers);

						return null;
					}

					@Override
					public void onDone(Void response)
					{

						MessageUtils.showInfoMessage(FunderCrudPanel.this, "Data has been saved");
					}
				}, this);
	}
	
}
