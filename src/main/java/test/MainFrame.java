package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.pushingpixels.flamingo.api.common.icon.ImageWrapperResizableIcon;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.JRibbonFrame;
import org.pushingpixels.flamingo.api.ribbon.RibbonApplicationMenu;
import org.pushingpixels.flamingo.api.ribbon.RibbonTask;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;
import org.pushingpixels.flamingo.api.ribbon.resize.IconRibbonBandResizePolicy;
import org.pushingpixels.flamingo.api.ribbon.resize.RibbonBandResizePolicy;

import client.App;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.model.accounting.TransactionCause;
import desktopadmin.model.accounting.payment.Check;

/**
 * Main Frame to demonstrate ribbon use.
 * 
 * @author <a href="http://blog.frankel.ch/">Nicolas Frankel</a>
 * @date 26 juin 2010
 * @version 1.0
 * 
 */
public class MainFrame extends JRibbonFrame
{

	/** Serial version unique id. */
	private static final long serialVersionUID = 1L;

	public static ResizableIcon getResizableIconFromResource(String resource)
	{

		return ImageWrapperResizableIcon.getIcon(MainFrame.class.getClassLoader().getResource(resource), new Dimension(48, 48));
	}

	/**
	 * Entry point method.
	 * 
	 * @param args
	 *            Application arguments
	 */

	public static void start( )
	{
		JPanel myPanel = new JPanel(new BorderLayout());
		SwingUtilities.invokeLater(new Runnable()
		{

			@SuppressWarnings({
			"unchecked", "rawtypes"
			})
			@Override
			public void run( )
			{

				MainFrame frame = new MainFrame();
				frame.fillChecks();

				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);

				JRibbonBand users = new JRibbonBand("Users", getResizableIconFromResource("48px-Crystal_Clear_app_Staroffice.png"));
				JRibbonBand transactions = new JRibbonBand("Transactions", getResizableIconFromResource("48px-Crystal_Clear_app_Staroffice.png"));
				JRibbonBand projects = new JRibbonBand("Projects", getResizableIconFromResource("48px-Crystal_Clear_app_Staroffice.png"));

				UserMenu.drawUserMenu(myPanel, users);
				UserMenu.drawTransactions(myPanel, transactions);
				UserMenu.drawProjects(myPanel, projects);

				users.setResizePolicies((List) Arrays.asList(
						new CoreRibbonResizePolicies.None(users.getControlPanel()),
						new CoreRibbonResizePolicies.Mirror(users.getControlPanel()),
						new CoreRibbonResizePolicies.Mid2Low(users.getControlPanel()),
						new IconRibbonBandResizePolicy(users.getControlPanel())
						));
				
				List<RibbonBandResizePolicy> bandResizePolicies = new ArrayList<>();
				bandResizePolicies.add(new CoreRibbonResizePolicies.None(transactions.getControlPanel()));
				bandResizePolicies.add(new CoreRibbonResizePolicies.Mirror(transactions.getControlPanel()));
				bandResizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(transactions.getControlPanel()));
				bandResizePolicies.add(new CoreRibbonResizePolicies.Mid2Low(transactions.getControlPanel()));
				transactions.setResizePolicies(bandResizePolicies);
				
				projects.setResizePolicies((List) Arrays.asList(
						new CoreRibbonResizePolicies.None(projects.getControlPanel()),
						new CoreRibbonResizePolicies.Mirror(projects.getControlPanel()),
						new CoreRibbonResizePolicies.Mid2Low(projects.getControlPanel()),
						new IconRibbonBandResizePolicy(projects.getControlPanel())
						));
				

				RibbonTask task1 = new RibbonTask("Users", users);
				RibbonTask task2 = new RibbonTask("Transactions", transactions);
				RibbonTask task3 = new RibbonTask("Projects", projects);

				frame.getRibbon().addTask(task1);
				frame.getRibbon().addTask(task2);
				frame.getRibbon().addTask(task3);

				JScrollPane scrollPane = new JScrollPane(myPanel);
				scrollPane.setPreferredSize(new Dimension(750, 400));
				frame.add(myPanel);

				frame.getRibbon().setApplicationMenu(new RibbonApplicationMenu());
				frame.pack();
			}
		});
	}

	public static void main(String[] args)
	{
		start();

	}

	public void fillChecks( )
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
				DataUtils.setChecks(response);

			}
		}, this);

		ProgressBar.execute(new ProgressBarListener<List<TransactionCause>>()
		{

			@Override
			public List<TransactionCause> onBackground( ) throws Exception
			{
				return App.getCrudService().list(TransactionCause.class);
			}

			@Override
			public void onDone(List<TransactionCause> response)
			{
				DataUtils.setTransactionCauses(response);

			}
		}, this);
	}
}
