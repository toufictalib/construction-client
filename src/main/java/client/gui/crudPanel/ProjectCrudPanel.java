package client.gui.crudPanel;

import java.rmi.RemoteException;
import java.util.List;
import java.util.stream.Collectors;

import client.App;
import client.bean.CrudProject;
import client.gui.crudPanel.subPanel.AddressMyComponent;
import client.rmiclient.classes.crud.ExtendedCrudPanel;
import client.rmiclient.classes.crud.ModelHolder;
import client.utils.MessageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.model.building.Project;

public class ProjectCrudPanel extends ExtendedCrudPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -897114854988642360L;

	private Class<CrudProject> clazz = CrudProject.class;
	
	public ProjectCrudPanel( )
	{
		super("Project");
	}

	@Override
	protected void fillCrudTable( )
	{
		ProgressBar.execute(new ProgressBarListener<List<Project>>()
		{

			@Override
			public List<Project> onBackground( ) throws Exception
			{
				return App.getCrudService().list(Project.class);
			}

			@Override
			public void onDone(List<Project> response)
			{
				List<CrudProject> crudProjects = response.stream().map(e->CrudProject.fromProject(e)).collect(Collectors.toList());
				
				crudPanel.fillValues(new ModelHolder(crudProjects, CrudProject.class));
			}
		}, this);
		

	}
	
	@Override
	public void initComponents( )
	{
		// TODO Auto-generated method stub
		super.initComponents();
		crudPanel.getBeanComplexElement().addComponent("address", new AddressMyComponent());
	}

	@Override
	protected void btnCancelAction( )
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected void btnSaveAction( )
	{
		try
		{
			List<CrudProject> result = crudPanel.getResult(clazz);
			List<Project> projects = result.stream().map(e->e.toProject()).collect(Collectors.toList());
			App.getCrudService().saveOrUpdate(projects);
		}
		catch (InstantiationException | IllegalAccessException | RemoteException e)
		{
			MessageUtils.showErrorMessage(this, e.getMessage());
		}

	}

}
