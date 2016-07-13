package client.gui.crudPanel;

import java.util.ArrayList;
import java.util.Arrays;

import client.bean.CrudFlat;
import client.rmiclient.classes.crud.BeanComplexElement;
import client.rmiclient.classes.crud.ExtendedCrudPanel;
import client.rmiclient.classes.crud.ModelHolder;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.model.accounting.EnumType.Direction;
import desktopadmin.model.building.Flat;

public class FlatCrudPanel extends ExtendedCrudPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -897114854988642360L;
	private BeanComplexElement beanComplexElement;
	public FlatCrudPanel( )
	{
		super("Flat");
	}

	@Override
	protected void fillCrudTable( )
	{
		ProgressBar.execute(new ProgressBarListener<Flat>()
		{

			@Override
			public Flat onBackground( ) throws Exception
			{
				return null;
			}

			@Override
			public void onDone(Flat response)
			{
				// TODO Auto-generated method stub
				
			}
		}, this);
		
		crudPanel.fillValues(new ModelHolder(new ArrayList<CrudFlat>(), CrudFlat.class));

	}
	
	@Override
	public void initComponents( )
	{
		// TODO Auto-generated method stub
		super.initComponents();
		beanComplexElement = new BeanComplexElement();
		crudPanel.setBeanComplexElement(beanComplexElement);
		beanComplexElement.addObjects("block", new ArrayList<>());
		beanComplexElement.addObjects("direction",Arrays.asList(Direction.values()));
	}

	@Override
	protected void btnCancelAction( )
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void btnSaveAction( )
	{
		// TODO Auto-generated method stub

	}

}
