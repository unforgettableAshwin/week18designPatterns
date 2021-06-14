package week18designPatterns;

public class UnknownCreditCardTypeException extends Exception
{
	private static final long serialVersionUID = 1L;

	public UnknownCreditCardTypeException(
			String message
	)
	{
		super( message );
	}
}
