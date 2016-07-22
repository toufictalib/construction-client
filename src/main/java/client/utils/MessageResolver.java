package client.utils;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

public class MessageResolver
{
	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;

	private String HEADER_LANGUAGE = "en";

	public MessageResolver()
	{
		System.out.println("MessageResolver Created");
	}

	public String getString(String key)
	{
		String language = "en";
		language = language == null ? "en" : language;
		String message = "";
		if ( !StringUtils.isEmpty(key))
		{
			message = messageSource.getMessage(key, null, message, new Locale(language));
		}
		return message;
	}

	public String generateLocalizedMessage(String messageKey)
	{
		String language ="en";
		language = language == null ? "en" : language;
		String defaultMessageKey = "general.unknownError";
		String message = messageSource.getMessage(defaultMessageKey, null, new Locale(language));
		if ( !StringUtils.isEmpty(messageKey))
		{
			message = messageSource.getMessage(messageKey, null, message, new Locale(language));
		}
		return message;
	}

	public String generateLocalizedMessage(String messageKey, Object... args)
	{
		String language = "en";
		language = language == null ? "en" : language;
		String defaultMessageKey = "general.unknownError";
		String message = messageSource.getMessage(defaultMessageKey, null, new Locale(language));
		if ( !StringUtils.isEmpty(messageKey))
		{
			message = messageSource.getMessage(messageKey, args, message, new Locale(language));
		}
		return message;
	}

	public String generateLocalizedErrorTitle( )
	{
		String language = "en";
		language = language == null ? "en" : language;
		String resourceKey = "general.errorTitle";
		String title = messageSource.getMessage(resourceKey, null, new Locale(language));
		return title;
	}
}
