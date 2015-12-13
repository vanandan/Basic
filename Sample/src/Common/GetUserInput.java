package Common;
import java.util.Scanner;

import CustomException.InvalidEntryException;

public class GetUserInput
{

	public Integer getNaturalNumberInput(String message) throws InvalidEntryException
	{
		int input = getIntInput(message);
		
		if (input < 0)
			throw new InvalidEntryException(Integer.toString(input));

		return input;
	}
	
	public Integer getPositiveNumberInput(String message) throws InvalidEntryException
	{
		int input = getIntInput(message);
		
		if (input <= 0)
			throw new InvalidEntryException().positiveNumException(input);

		return input;

	}
	
	private Integer getIntInput(String message) throws InvalidEntryException
	{
		String uInput = null;
		System.out.println(message);
		Scanner sc = new Scanner(System.in);
		try
		{
			uInput = sc.nextLine();
			return Integer.parseInt(uInput);
		}
		catch (Exception e)
		{
			throw new InvalidEntryException(uInput);
		}
	}

	public String getStringInput(String message)
	{
		System.out.println(message);
		Scanner sc = new Scanner(System.in);

		return sc.next();

	}

}
