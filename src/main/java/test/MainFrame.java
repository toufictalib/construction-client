package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import org.pushingpixels.flamingo.api.common.JCommandButton;
import org.pushingpixels.flamingo.api.common.JCommandButton.CommandButtonKind;
import org.pushingpixels.flamingo.api.common.icon.ImageWrapperResizableIcon;
import org.pushingpixels.flamingo.api.common.icon.ResizableIcon;
import org.pushingpixels.flamingo.api.ribbon.JRibbonBand;
import org.pushingpixels.flamingo.api.ribbon.JRibbonFrame;
import org.pushingpixels.flamingo.api.ribbon.RibbonApplicationMenu;
import org.pushingpixels.flamingo.api.ribbon.RibbonApplicationMenuEntryPrimary;
import org.pushingpixels.flamingo.api.ribbon.RibbonTask;
import org.pushingpixels.flamingo.api.ribbon.resize.CoreRibbonResizePolicies;
import org.pushingpixels.flamingo.api.ribbon.resize.IconRibbonBandResizePolicy;
import org.pushingpixels.flamingo.api.ribbon.resize.RibbonBandResizePolicy;

import client.App;
import client.gui.image.ImageUtils;
import client.utils.ProgressBar;
import client.utils.ProgressBar.ProgressBarListener;
import desktopadmin.model.accounting.TransactionCause;
import desktopadmin.model.accounting.payment.Check;
import desktopadmin.model.stock.Product;

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

	private static URL getUrl(String path) {
        URL url = MainFrame.class.getResource(path);
        if (url == null) {
            url = MainFrame.class.getClassLoader().getResource(path);
        }
        return url;
    }
	
	public static ResizableIcon getResizableIconFromResource(String resource)
	{

		return ImageWrapperResizableIcon.getIcon(getUrl("images/menus/"+resource), new Dimension(48, 48));
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

				

				JRibbonBand users = new JRibbonBand("Users", getResizableIconFromResource("48px-Crystal_Clear_app_Staroffice.png"));
				JRibbonBand main = new JRibbonBand("Main", getResizableIconFromResource("48px-Crystal_Clear_app_Staroffice.png"));
				JRibbonBand transactions = new JRibbonBand("Misc", getResizableIconFromResource("48px-Crystal_Clear_app_Staroffice.png"));
				JRibbonBand projects = new JRibbonBand("Projects", getResizableIconFromResource("project.png"));
				JRibbonBand stocks = new JRibbonBand("Stock", getResizableIconFromResource("48px-Crystal_Clear_app_Staroffice.png"));

				UserMenu.drawUserMenu(myPanel, users);
				UserMenu.drawMainMenu(myPanel, main);
				UserMenu.drawTransactions(myPanel, transactions);
				JCommandButton drawProject = UserMenu.drawProjects(myPanel, projects);
				
				

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
				
				projects.setResizePolicies(bandResizePolicies);
				main.setResizePolicies(bandResizePolicies);

				RibbonTask task3 = new RibbonTask("Projects", projects);
				RibbonTask task1 = new RibbonTask("Users", users);
				RibbonTask task2 = new RibbonTask("Misc", transactions);
				//RibbonTask mainTask = new RibbonTask("Main", main);

				
				

				//fire project menu
				drawProject.doActionClick();
				
				
				
				RibbonApplicationMenu ribbonApplicationMenu = new RibbonApplicationMenu();
				ribbonApplicationMenu.addMenuEntry(new RibbonApplicationMenuEntryPrimary(getResizableIconFromResource("48px-Crystal_Clear_app_Staroffice.png"), "Main Menu", new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						// TODO Auto-generated method stub
						
					}
				}, CommandButtonKind.ACTION_AND_POPUP_MAIN_ACTION));
				
				
				//frame
				JScrollPane scrollPane = new JScrollPane(myPanel);
				scrollPane.setPreferredSize(new Dimension(750, 400));
				
				MainFrame frame = new MainFrame();
				frame.fillChecks();

				frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
				frame.add(myPanel);
				
				//frame.getRibbon().addTask(mainTask);
				frame.getRibbon().addTask(task3);
				frame.getRibbon().addTask(task2);
				frame.getRibbon().addTask(task1);
				//frame.getRibbon().setApplicationMenu(ribbonApplicationMenu);
				frame.pack();
				frame.setIconImage(ImageUtils.getSoftwareIcon().getImage());
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		
		ProgressBar.execute(new ProgressBarListener<List<Product>>()
				{

					@Override
					public List<Product> onBackground( ) throws Exception
					{
						return App.getCrudService().list(Product.class);
					}

					@Override
					public void onDone(List<Product> response)
					{
						DataUtils.setProducts(response);

					}
				}, this);
	}
}
