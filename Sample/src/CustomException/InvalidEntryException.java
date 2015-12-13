package CustomException;
public class InvalidEntryException extends Exception
{
	String userEntry;

	public InvalidEntryException(String entry)
	{
		userEntry = entry;
		System.out.println(userEntry + " is not a valid entry.");
	}
	
	public InvalidEntryException()
	{
		
	}

	public String getEntry()
	{
		return userEntry;
	}

	public InvalidEntryException positiveNumException(Integer userInput)
	{
		System.out.println(userInput + "is not a positive number.");
		return this;
	}

}
