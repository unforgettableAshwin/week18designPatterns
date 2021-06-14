package week18designPatterns;

public class CreditCardFactory
{
	public CreditCardFactory()
	{

	}

	public static CreditCard getCard(
			String record
	) throws Exception
	{
//		MasterCard
//		First digit is a 5 or 2, the second digit is in the range 1 through 5 inclusive. Only valid length of number is 16 digits.

//		Visa
//		First digit is a 4. Length is either 13 or 16 digits.

//		AmericanExpress
//		First digit is a 3 and second digit a 4 or 7. The length is 15 digits.

//		Discover
//		First four digits are 6011. The length is 16 digits.

		String[] s = record.split( "," );
		String ccn = s[ CreditCardRecordElements.number.getValue() ].replaceAll( " ", "" );
		CreditCardTypes t = null;
		char c2nd = ccn.charAt( 1 );
		switch( ccn.charAt( 0 ) )
		{
			case '5':
			case '2':
				int i2nd = Character.getNumericValue( c2nd );
				if( i2nd > 0 && i2nd < 6 )
					t = CreditCardTypes.MasterCard;
				else
					throw new UnknownCreditCardTypeException( "" );
				break;
			case '4':
				t = CreditCardTypes.Visa;
				break;
			case '3':
				if( c2nd == '4' || c2nd == '7' )
					t = CreditCardTypes.AmericanExpress;
				else
					throw new UnknownCreditCardTypeException( "" );
				break;
			case '6':
				if( ccn.substring( 1, 4 ).compareTo( "011" ) == 0 )
					t = CreditCardTypes.Discover;
				else
					throw new UnknownCreditCardTypeException( "" );
				break;
			default:
				throw new UnknownCreditCardTypeException( "" );
		}

		return checkLength( t, ccn, record );
	}

	private static CreditCard checkLength(
			CreditCardTypes t,
			String ccn,
			String record
	) throws Exception
	{
		CreditCard cc = null;

		int len = ccn.length();
//		MasterCard
//		First digit is a 5 or 2, the second digit is in the range 1 through 5 inclusive. Only valid length of number is 16 digits.

//		Visa
//		First digit is a 4. Length is either 13 or 16 digits.

//		AmericanExpress
//		First digit is a 3 and second digit a 4 or 7. The length is 15 digits.

//		Discover
//		First four digits are 6011. The length is 16 digits.

		switch( t )
		{
			case AmericanExpress:
				if( len == 15 )
				{
					cc = new AmExCC();
					cc.typeName = "American Epress";
				}
				else
					throw new UnknownCreditCardTypeException( "" );
				break;
			case Visa:
				if( len == 13 || len == 16 )
				{
					cc = new VisaCC();
					cc.typeName = "Visa";
				}
				else
					throw new UnknownCreditCardTypeException( "" );
				break;
			case MasterCard:
				if( len == 16 )
				{
					cc = new MasterCC();
					cc.typeName = "MasterCard";
				}
				else
					throw new UnknownCreditCardTypeException( "" );
				break;
			case Discover:
				if( len == 16 )
				{
					cc = new DiscoverCC();
					cc.typeName = "Discover";
				}
				else
					throw new UnknownCreditCardTypeException( "" );
				break;
		}

		if( cc != null )
			cc.record = record;

		return cc;
	}
}
