package client.utils;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageFactory
{
	private static MessageResolver messageResolver;

	/*private static MessageFactory instance;

	public static MessageFactory get( )
	{
		if (instance == null)
		{
			instance = new MessageFactory();
		}
		return instance;
	}*/
	
	public MessageFactory(MessageResolver messageResolver)
	{
		this.messageResolver = messageResolver;
	}
	
	public static String getMessage(String key)
	{
		return messageResolver.getString(key);
	}
	public static MessageResolver getMessageResolver( )
	{
		return messageResolver;
	}
	public static void setMessageResolver(MessageResolver messageResolver)
	{
		MessageFactory.messageResolver = messageResolver;
	}
	
	

}
