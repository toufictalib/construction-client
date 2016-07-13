package client.gui.crudPanel;

import java.util.List;
import java.util.stream.Collectors;

import test.DataUtils;
import client.App;
import client.bean.CrudCheck;
import client.rmiclient.classes.crud.ExtendedCrudPanel;
import client.rmiclient.classes.crud.ModelHolder;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.model.accounting.payment.Check;

public class CheckCrudPanel extends ExtendedCrudPanel
{

	public CheckCrudPanel( )
	{
		super("Check");
	}

	
	@Override
	protected void fillCrudTable( )
	{
		ProgressBar.execute(new ProgressBarListener<List<Check>>()
		{

			@Override
			public List<Check> onBackground( ) throws Exception
			{
				return App.getCrudService().list(Check.class);
			}

			@Override
			public void onDone(List<Check> response)
			{
				crudPanel.fillValues(new ModelHolder(response.stream().map(e -> CrudCheck.fromCheck(e)).collect(Collectors.toList()), CrudCheck.class));

			}
		}, this);

	}

	public void initComponents( )
	{
		super.initComponents();
		
		crudPanel.getBeanComplexElement().addObjects("bank", DataUtils.banks());

	};

	@Override
	protected void btnSaveAction( )
	{
		ProgressBar.execute(new ProgressBarListener<Void>()
		{

			@Override
			public Void onBackground( ) throws Exception
			{
				List<Check> checks = crudPanel.getResult(CrudCheck.class).stream().map(e->e.toCheck()).collect(Collectors.toList());
				App.getCrudService().saveOrUpdate(checks);
				return null;
			}

			@Override
			public void onDone(Void response)
			{
				System.out.println("Checks has been Saved");
			}
		}, this);

	}

	@Override
	protected void btnCancelAction( )
	{
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3557682102783687001L;

}
