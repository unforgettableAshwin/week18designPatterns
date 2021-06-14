package week18designPatterns;

public class CreditCard
{
	public CreditCard()
	{
	}

	@Override public String toString()
	{
		return typeName + ": " + record;
	}

	public String getRecord()
	{
		return record;
	}

	public void setRecord(
			String record
	)
	{
		this.record = record;
	}

	public String getTypeName()
	{
		return typeName;
	}

	public void setTypeName(
			String typeName
	)
	{
		this.typeName = typeName;
	}

	String record;
	String typeName;
}
