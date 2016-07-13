package client;

import java.rmi.RemoteException;

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
