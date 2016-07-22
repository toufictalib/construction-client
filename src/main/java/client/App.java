package client;

import java.rmi.RemoteException;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.MainFrame;
import desktopadmin.action.Crud;


public class App
{
	private static Crud crudService;
	
	
	public static Crud getCrudService( )
	{
		return crudService;
	}


	public static void setCrudService(Crud crudService)
	{
		App.crudService = crudService;
	}


	public static void main(String[] args)
	{
		
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                   // UIManager.put("Table.alternateRowColor", Color.decode("#cae0f4"));
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();   // If Nimbus is not available, you can set the GUI to another look and feel.
        }
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/config/client-beans.xml");  
		Crud calculation = (Crud)context.getBean("cc");  
		setCrudService(calculation);
		
		MainFrame.start();
		
		
		try
		{
			System.out.println(calculation.getName());
		}
		catch (RemoteException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
}
