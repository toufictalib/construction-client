package client.response.general;

public class Dialog
{
	private String title;

	private String message;

	public Dialog( )
	{

	}

	public Dialog(String title, String message)
	{
		this();
		this.title = title;
		this.message = message;

	}

	public String getTitle( )
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getMessage( )
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}