/**
Describe what is the primary problem you are trying to solve. (P1)
	Implement a solution to read records from a credit card file.
	
Describe what are the secondary problems you try to solve (if there are any). (P2/P3)
	Determine if the number is valid and what type of card it is.
	
Describe what design pattern(s) you use how (use plain text and/or diagrams).
	Factory Pattern: Create a credit card factory class that takes a credit card number and returns a credit card class of the 	appropriate type. 
	
Describe the consequences of using this/these pattern(s).
	Not using a class's constructor allows a system to be more closed for modification and more open to extension. Modifications don't affect the foundational classes of the 
	system. Adding a new subclass only affects the factory. Changing how a subclass is created only affects the factory too. In both cases, no existing fundamental classes 
	are affected.
	 
 * 
 */
package week18designPatterns;

/**
 * @author ashwin
 *
 */
public class week18designPatterns
{
	public static void main(
			String[] args
	) throws UnknownCreditCardTypeException
	{

//		MasterCard
//		First digit is a 5 or 2, the second digit is in the range 1 through 5 inclusive. Only valid length of number is 16 digits.

//		Visa
//		First digit is a 4. Length is either 13 or 16 digits.

//		AmericanExpress
//		First digit is a 3 and second digit a 4 or 7. The length is 15 digits.

//		Discover
//		First four digits are 6011. The length is 16 digits.

		String[] lines = new String[ 15 ];

		char c = 0;
		// m:
		lines[ c++ ] = "5100 1234 1234 1234, 07/22, m John Doe";
		lines[ c++ ] = "2200 0000 0000 0000, 07/23, m card holder name 0";
		lines[ c++ ] = "2300 0000 0000 0000, 07/29, m card holder name 6";
		lines[ c++ ] = "2300 0000 0000 0000, 07/30, m card holder name 7";
		lines[ c++ ] = "2400 0000 0000 0000, 07/31, m card holder name 8";
		lines[ c++ ] = "2500 0000 0000 0000, 07/32, m card holder name 9";
		// v:
		lines[ c++ ] = "4000 0000 0000 0, 07/24, v card holder name 1";
		lines[ c++ ] = "4000 0000 0000 0000, 07/25, v card holder name 2";
		// a:
		lines[ c++ ] = "3400 0000 0000 000, 07/26, a card holder name 3";
		lines[ c++ ] = "3700 0000 0000 000, 07/27, a card holder name 4";
		// d:
		lines[ c++ ] = "6011 0000 0000 0000, 07/28, d card holder name 5";
		// test invalid:
		lines[ c++ ] = "6011 0000 0000 000, 06/22, card holder name";
		CreditCard cc;
		for( String s: lines )
			if( s != null )
				try
				{
					cc = CreditCardFactory.getCard( s );
					System.out.println( cc.toString() );
				}
				catch( UnknownCreditCardTypeException e )
				{
					System.out.println( "Unable to instantiate from known credit types:\r\n" + s );
				}
				catch( Exception e )
				{
					e.printStackTrace();
				}
	}
}
