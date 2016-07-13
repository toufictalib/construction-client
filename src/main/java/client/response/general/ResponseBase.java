package client.response.general;

import java.util.HashMap;

public class ResponseBase
{
	private boolean status;

	private String code;

	private Dialog dialog;

	// private MsisdnVerification verification;

	private HashMap<String, Object> extra;

	public ResponseBase( )
	{
	}

	protected ResponseBase(ResponseBaseBuilder builder)
	{
		this.setStatus(builder.status);
		this.setCode(builder.code);
		this.setExtra(builder.extra);
		if (builder.title != null || builder.message != null)
		{
			dialog = new Dialog();
			dialog.setTitle(builder.title);
			dialog.setMessage(builder.message);
		}
		// if(builder.msisdnVerification != null) {
		// setVerification(builder.msisdnVerification);
		// }
	}

	public static ResponseBaseBuilder successNoObject( )
	{
		ResponseBaseBuilder builder = new ResponseBaseBuilder();
		builder.status = true;
		builder.code = null;
		return builder;
	}

	public static ResponseBaseBuilder failureNoObject(String code)
	{
		ResponseBaseBuilder builder = new ResponseBaseBuilder();
		builder.status = false;
		builder.code = code;
		return builder;
	}

	public boolean isStatus( )
	{
		return status;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

	public String getCode( )
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public HashMap<String, Object> getExtra( )
	{
		return extra;
	}

	public void setExtra(HashMap<String, Object> extra)
	{
		this.extra = extra;
	}

	public static class ResponseBaseBuilder
	{
		public boolean status;

		public String code;

		public String title;

		public String message;

		public HashMap<String, Object> extra;

		public ResponseBaseBuilder put(String key, Object value)
		{
			if (extra == null)
			{
				extra = new HashMap<String, Object>();
			}
			extra.put(key, value);
			return this;
		}

		public ResponseBaseBuilder dialog(String title, String message)
		{
			this.title = title;
			this.message = message;
			return this;
		}

		public ResponseBase build( )
		{
			return new ResponseBase(this);
		}
	}

	public Dialog getDialog( )
	{
		return dialog;
	}

	public void setDialog(Dialog dialog)
	{
		this.dialog = dialog;
	}
	

	// public MsisdnVerification getVerification( )
	// {
	// return verification;
	// }
	//
	// public void setVerification(MsisdnVerification verification)
	// {
	// this.verification = verification;
	// }
}
