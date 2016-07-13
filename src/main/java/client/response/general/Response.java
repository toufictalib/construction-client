package client.response.general;

public class Response<T> extends ResponseBase
{
	public T data;

	public Response( )
	{
		super();
	}

	private Response(ResponseBuilder<T> builder)
	{
		super(builder);
		this.data = builder.data;
	}

	public static <T> ResponseBuilder<T> success( )
	{
		ResponseBuilder<T> builder = new ResponseBuilder<T>();
		builder.status = true;
		builder.code = null;
		return builder;
	}

	public static <T> ResponseBuilder<T> failure(String code)
	{
		ResponseBuilder<T> builder = new ResponseBuilder<T>();
		builder.status = false;
		builder.code = code;
		return builder;
	}

	public static class ResponseBuilder<T> extends ResponseBase.ResponseBaseBuilder
	{
		private T data;

		public ResponseBuilder<T> setBean(T data)
		{
			this.data = data;
			return this;
		}

		public ResponseBuilder<T> put(String key, Object value)
		{
			super.put(key, value);
			return this;
		}

		public ResponseBuilder<T> dialog(String title, String message)
		{
			super.dialog(title, message);
			return this;
		}

		public Response<T> build( )
		{
			return new Response<T>(this);
		}
	}
}
