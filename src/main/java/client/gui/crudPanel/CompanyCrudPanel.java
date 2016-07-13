package client.gui.crudPanel;

import java.util.List;
import java.util.stream.Collectors;

import test.DataUtils;
import client.App;
import client.bean.CrudCompany;
import client.rmiclient.classes.crud.BeanComplexElement;
import client.rmiclient.classes.crud.ExtendedCrudPanel;
import client.rmiclient.classes.crud.ModelHolder;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.model.person.Company;

public class CompanyCrudPanel extends ExtendedCrudPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -897114854988642360L;
	private BeanComplexElement beanComplexElement;
	public CompanyCrudPanel( )
	{
		super("Compagny");
	}
	
	public CompanyCrudPanel(String title )
	{
		super(title);
	}

	@Override
	protected void fillCrudTable( )
	{
		ProgressBar.execute(new ProgressBarListener<List<Company>>()
				{

					@Override
					public List<Company> onBackground( ) throws Exception
					{
						return App.getCrudService().list(Company.class);
					}

					@Override
					public void onDone(List<Company> response)
					{
						crudPanel.fillValues(new ModelHolder(response.stream()
								.map(e->CrudCompany.fromModel(e)).collect(Collectors.toList()), CrudCompany.class));
						
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
						List<CrudCompany> result = crudPanel.getResult(CrudCompany.class);
						List<Company> data = result.stream().map(e -> e.toModel()).collect(Collectors.toList());
						App.getCrudService().saveOrUpdate(data);

						return null;
					}

					@Override
					public void onDone(Void response)
					{

						MessageUtils.showInfoMessage(CompanyCrudPanel.this, "Data has been saved");
					}
				}, this);

	}

}
