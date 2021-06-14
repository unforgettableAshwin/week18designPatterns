package week18designPatterns;

public enum CreditCardRecordElements
{
	number( 0 ), expiration( 1 ), name( 2 );

	private int index;

	CreditCardRecordElements(
			int index
	)
	{
		this.index = index;
	}

	public int getValue()
	{
		return index;
	}
}
