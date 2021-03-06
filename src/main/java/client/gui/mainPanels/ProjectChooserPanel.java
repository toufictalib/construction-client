package client.gui.mainPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JButton;

import report.bean.CustomerReportBean;
import client.App;
import client.gui.button.ButtonFactory;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.utils.ExList;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;
import com.jgoodies.forms.layout.FormLayout;

import desktopadmin.model.building.Project;
import desktopadmin.utils.SearchBean;

public class ProjectChooserPanel extends JpanelTemplate implements ActionListener
{
	private static final long serialVersionUID = 6740700021071798084L;

	private ExList<Project> listProjects;

	private JButton btnApply;

	private ProjectButtonsActionListener projectButtonsActionListener;
	
	private boolean addButtons = true;
	
	public ProjectChooserPanel( ProjectButtonsActionListener projectButtonsActionListener)
	{
		this.projectButtonsActionListener = projectButtonsActionListener;
		if(projectButtonsActionListener==null)
		{
			throw new IllegalArgumentException(getClass().getName()+" should have a projectButtonsActionListener");
		}
	}
	
	public ProjectChooserPanel()
	{
		this.addButtons = false;
	}
	
	
	@Override
	public void init( )
	{
		DefaultFormBuilder builder = new DefaultFormBuilder(new FormLayout("fill:p:grow","p,fill:p:grow,p,p"),this);
		builder.setDefaultDialogBorder();

		builder.appendSeparator("Choose Project");
		builder.append(listProjects);
		
		if(addButtons)
		{
		builder.appendSeparator();

		builder.append(ButtonBarFactory.buildRightAlignedBar(btnApply));
		}

	}

	@Override
	public void initComponents( )
	{
		btnApply = ButtonFactory.createBtnApply();
		btnApply.addActionListener(this);

		listProjects = new ExList<Project>();
		listProjects.setVisibleRowCount(7);
		listProjects.addMouseListener(new MouseAdapter()
		{
			
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)
				{
					btnApply.doClick();
				}
				
			}
		});

		fillCrudTable();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnApply)
		{
			projectButtonsActionListener.btnApplyAction(listProjects.getValue());
			
		}

	}

	private void fillCrudTable( )
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
					listProjects.setValues(response);
			}
		}, this);

	}

	public interface ProjectButtonsActionListener
	{
		public void btnApplyAction(Project project);
	}

}
