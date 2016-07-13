package client.gui.mainPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import test.DataUtils;
import client.bean.CrudProject;
import client.gui.button.ButtonFactory;
import client.rmiclient.classes.crud.JpanelTemplate;
import client.utils.BuilderUtils;
import client.utils.ExList;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;

public class ProjectChooserPanel extends JpanelTemplate implements ActionListener
{
	private static final long serialVersionUID = 6740700021071798084L;

	
	private ExList<CrudProject> listProjects;


	private JButton btnApply; 
	
	@Override
	public void init( )
	{
		DefaultFormBuilder builder = BuilderUtils.build(this, "fill:p:grow");
		builder.setDefaultDialogBorder();
		
		builder.appendSeparator("Choose Project");
		builder.append(listProjects);
		builder.appendSeparator();
		
		builder.append(ButtonBarFactory.buildRightAlignedBar(btnApply));

	}

	@Override
	public void initComponents( )
	{
		btnApply = ButtonFactory.createBtnApply();
		btnApply.addActionListener(this);

		listProjects = new ExList<CrudProject>(DataUtils.projects());
		listProjects.setVisibleRowCount(7);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
